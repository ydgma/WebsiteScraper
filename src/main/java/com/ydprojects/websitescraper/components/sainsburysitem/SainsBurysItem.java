package com.ydprojects.websitescraper.components.sainsburysitem;


import org.jsoup.nodes.Element;

public interface SainsBurysItem {

    String getTitle();
    String getKcal_per_100g();
    String getUnit_price();
    String getDescription();
    Element getElement();

}
