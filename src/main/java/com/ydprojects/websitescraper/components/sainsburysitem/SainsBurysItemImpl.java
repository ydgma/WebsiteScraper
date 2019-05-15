package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SainsBurysItemImpl implements SainsBurysItem{

    Element element;
    private SainsBurysItemInfo sainsBurysItemInfo;

    public SainsBurysItemImpl (Element element) {
        this.element = element;
    }

    @Override
    public String getTitle() {
        return element.getElementsByClass("productNameAndPromotions").text();
    }

    @Override
    public String getKcal_per_100g() {
       return  sainsBurysItemInfo.getKclper100g();
    }

    @Override
    public String getUnit_price() {
        return element.getElementsByClass("pricePerUnit").text();
    }

    @Override
    public String getDescription() {
       return sainsBurysItemInfo.getDescription();
    }
}
