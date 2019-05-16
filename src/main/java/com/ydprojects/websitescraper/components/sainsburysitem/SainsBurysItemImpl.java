package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SainsBurysItemImpl implements SainsBurysItem{

    Element element;
    private SainsBurysItemInfo sainsBurysItemInfo;

    public SainsBurysItemImpl (Element element) {
        this.element = element;
    }

    private String createItemInfoUrl(String extractedUrl) {
        // need to do some funky regex
        return null;
    }

    @Override
    public String getTitle() {
        return element.getElementsByClass("productNameAndPromotions")
                .first()
                .text();
    }

    @Override
    public String getKcal_per_100g() {
        return createItemInfoUrl(element.getElementsByClass("productNameAndPromotions").first().html());
    }

    @Override
    public String getUnit_price() {
        return element.getElementsByClass("pricePerUnit").text();
    }

    @Override
    public String getDescription() {
       return sainsBurysItemInfo.getDescription();
    }

    @Override
    public Element getElement() {
        return element;
    }
}
