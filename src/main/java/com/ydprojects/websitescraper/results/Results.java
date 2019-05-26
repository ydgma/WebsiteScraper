package com.ydprojects.websitescraper.results;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemListImpl;
import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.entity.util.JasonMapperUtil;
import com.ydprojects.websitescraper.results.util.TotalCalculatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Results {
    private static final Logger LOG = LoggerFactory.getLogger(Results.class);
    private List<Item> results = new ArrayList<>();
    private String pageUrl;
    private Map<String, BigDecimal> total = new HashMap<>();
    private Function<List<Item>,List<BigDecimal>> getListOfTotals =
            (k) -> k.stream().map(Item::getUnit_price).collect(Collectors.toList());

    public Results(String pageUrl) {
        this.pageUrl = Objects.requireNonNull(pageUrl, "PageUrl cannot be null");
        populateItems();
        setTotal();
    }

    public List<Item> getResults() {
        return results;
    }

    public Map<String, BigDecimal> getTotal() {
        return total;
    }

    private void populateItems() {
        new SainsBurysItemListImpl(pageUrl).getItemList()
                .forEach(sainsBurysItem -> results.add(new Item(sainsBurysItem)));
    }

    private void setTotal() {
        BigDecimal gross = TotalCalculatorUtil.calculateGross(getListOfTotals.apply(results));
        BigDecimal vat = TotalCalculatorUtil.calculateVat(gross);
        total.put("gross", gross);
        total.put("vat", vat);
    }

    @JsonIgnore
    public String getResultsAsJason() {
        return JasonMapperUtil.getResultsAsAJsonString(this);
    }

}
