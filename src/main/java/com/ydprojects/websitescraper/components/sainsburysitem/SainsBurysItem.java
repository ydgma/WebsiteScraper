package com.ydprojects.websitescraper.components.sainsburysitem;


import org.jsoup.nodes.Element;

import java.math.BigDecimal;
import java.util.Optional;

public interface SainsBurysItem {

    String getTitle();

    Optional<Integer> getKcal_per_100g();

    BigDecimal getUnit_price();

    Optional<String> getDescription();

    Element getElement();

}
