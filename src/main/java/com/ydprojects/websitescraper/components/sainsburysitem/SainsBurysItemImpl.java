package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SainsBurysItemImpl implements SainsBurysItem{

    Element element;
    private SainsBurysItemInfo sainsBurysItemInfo;
    String initialUrl = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/";

    public SainsBurysItemImpl (Element element) {
        this.element = element;
        sainsBurysItemInfo = new SainsBurysItemInfoImpl(createItemInfoUrl());
    }

    private String createItemInfoUrl() {
        String extractedHTML = element.getElementsByClass("productNameAndPromotions").first().html();
        String regex = "\">.*|\\../|.*?f=\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(extractedHTML);
        extractedHTML = matcher.replaceAll("");

        return initialUrl + extractedHTML;
    }

    @Override
    public String getTitle() {
        return element.getElementsByClass("productNameAndPromotions")
                .first()
                .text();
    }

    @Override
    public String getKcal_per_100g() {
        return sainsBurysItemInfo.getKclper100g();
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
