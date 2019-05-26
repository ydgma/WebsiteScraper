package com.ydprojects.websitescraper.entity.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItem;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({ "title", "kcal_per_100g", "unit_price", "description"})
public class Item {
    private static final Logger LOG = LoggerFactory.getLogger(Item.class);
    private SainsBurysItem sainsBurysItem;

    public Item(SainsBurysItemImpl sainsBurysItem) {
        this.sainsBurysItem = sainsBurysItem;
    }

    public String getTitle() {
        return sainsBurysItem.getTitle();
    }

    @JsonInclude(Include.NON_NULL)
    public Integer getKcal_per_100g() {
        Optional<Integer> optional = sainsBurysItem.getKcal_per_100g();
        return optional.orElse(null);
    }

    public BigDecimal getUnit_price() {
        return sainsBurysItem.getUnit_price();

    }

    public String getDescription() {
        Optional<String> optional = sainsBurysItem.getDescription();
        return optional.orElseThrow(() -> new NoSuchElementException("Item description could not be found"));
    }
}
