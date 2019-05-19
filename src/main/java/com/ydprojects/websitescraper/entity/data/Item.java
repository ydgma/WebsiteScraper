package com.ydprojects.websitescraper.entity.data;

import com.google.gson.Gson;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItem;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Item {

    private SainsBurysItem sainsBurysItem;

    public Item (SainsBurysItemImpl sainsBurysItem) {
        this.sainsBurysItem = sainsBurysItem;
    }

    public String getTitle() {
        return sainsBurysItem.getTitle();
    }

    public String getKcal_per_100g() {
        Optional<String> optional = sainsBurysItem.getKcal_per_100g();
       return optional.isPresent() ? optional.get() : "";
    }

    public String getDescription() {
        Optional<String> optional = sainsBurysItem.getDescription();
        return optional.isPresent() ? optional.get() : "";
    }

    public BigDecimal getUnit_price() {
       return sainsBurysItem.getUnit_price();

    }

}
