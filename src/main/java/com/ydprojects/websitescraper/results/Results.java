package com.ydprojects.websitescraper.results;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemListImpl;
import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.results.util.TotalCalculatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Results {
    private static final Logger LOG = LoggerFactory.getLogger(Results.class);
    private List<SainsBurysItemImpl> listOfValuesScraped;
    private List<Item> itemList = new ArrayList<>();
    private String pageUrl;
    private Map<String, BigDecimal> total = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();

    public Results(String pageUrl) {
        this.pageUrl = pageUrl;
        listOfValuesScraped = new SainsBurysItemListImpl(pageUrl).getItemList();
        populateItems();
        setTotal();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public Map<String, BigDecimal> getTotal() {
        return total;
    }

    private void populateItems() {
        listOfValuesScraped
                .forEach(sainsBurysItem -> itemList.add(new Item(sainsBurysItem)));
    }

    private void setTotal() {
        BigDecimal gross = TotalCalculatorUtil.calculateGross(itemList);
        BigDecimal vat = TotalCalculatorUtil.calculateVat(gross);
        total.put("gross", gross);
        total.put("vat", vat);
    }

}
