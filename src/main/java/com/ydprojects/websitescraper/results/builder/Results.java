package com.ydprojects.websitescraper.results.builder;


import com.fasterxml.jackson.databind.ObjectMapper;
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


public class Results {
    private static final Logger LOG = LoggerFactory.getLogger(Results.class);
    private static final List<SainsBurysItemImpl> listOfValuesScraped = new SainsBurysItemListImpl().getItemList();
    private List<Item> itemList = new ArrayList<>();
    private Map<String, BigDecimal> total = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();

    public Results() {
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

    public BigDecimal calculateGross(List<Item> listOfItems) {
        BigDecimal initial = new BigDecimal(0);

        for (Item item : listOfItems) {
            BigDecimal fromNewITem = item.getUnit_price();
            initial = initial.add(fromNewITem);
        }

        BigDecimal gross = initial.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return gross;
    }

    public BigDecimal calculateVat(BigDecimal gross) {
        BigDecimal vatPercentage = new BigDecimal(1.20);
        BigDecimal vat = gross.divide(vatPercentage, 2, BigDecimal.ROUND_HALF_EVEN);
        vat = vat.subtract(gross).multiply(new BigDecimal(-1));

        BigDecimal vatRounded = vat.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return vatRounded;
    }

    private void setTotal() {
        BigDecimal gross = calculateGross(itemList);
        BigDecimal vat = calculateVat(gross);
        total.put("gross", gross);
        total.put("vat", vat);
    }

}
