package com.ydprojects.websitescraper.entity.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItem;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

public class Item {
    private static final Logger LOG = LoggerFactory.getLogger(Item.class);
    private SainsBurysItem sainsBurysItem;
    private static final String EMPTY_STRING = "";

    public Item (SainsBurysItemImpl sainsBurysItem) {
        this.sainsBurysItem = sainsBurysItem;
    }

    public String getTitle() {
        return sainsBurysItem.getTitle();
    }

    @JsonInclude(Include.NON_EMPTY)
    public String getKcal_per_100g() {
        Optional<String> optional = sainsBurysItem.getKcal_per_100g();
       return optional.orElse(EMPTY_STRING);
    }

    @JsonInclude(Include.NON_EMPTY)
    public String getDescription() {
        Optional<String> optional = sainsBurysItem.getDescription();
        return optional.orElse(EMPTY_STRING);
    }

    public BigDecimal getUnit_price() {
       return sainsBurysItem.getUnit_price();

    }

}
