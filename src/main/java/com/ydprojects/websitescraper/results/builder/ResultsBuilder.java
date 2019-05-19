package com.ydprojects.websitescraper.results.builder;


import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItem;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemListImpl;
import com.ydprojects.websitescraper.entity.data.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResultsBuilder {
    private static final List<SainsBurysItemImpl> listOfValuesScraped = new SainsBurysItemListImpl().getItemList();
    private List<Item> itemList = new ArrayList<>();
    private Map<String,BigDecimal> total = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(ResultsBuilder.class);

    public ResultsBuilder() {
       populateItems();
       calculateTotal();
       calculateVat();

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public Map<String,BigDecimal> getTotal() {
        return total;
    }

    private void populateItems() {
        listOfValuesScraped
                .forEach(sainsBurysItem -> itemList.add(new Item(sainsBurysItem)));
    }

    private void calculateTotal() {
        BigDecimal initial = new BigDecimal(0);

        for(SainsBurysItemImpl item : listOfValuesScraped) {
            BigDecimal fromNewITem = item.getUnit_price();
            initial = initial.add(fromNewITem);
        }

        BigDecimal gross = initial.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        total.put("gross",gross);
    }

    private void calculateVat() {
        BigDecimal initial = new BigDecimal(5);
        BigDecimal vatPercentage = new BigDecimal(1.20);
        BigDecimal vat = initial.divide(vatPercentage,2,BigDecimal.ROUND_HALF_EVEN);
        vat = vat.subtract(initial).multiply(new BigDecimal(-1));
        
        BigDecimal vatRounded = vat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        total.put("vat",vatRounded);
    }



}
