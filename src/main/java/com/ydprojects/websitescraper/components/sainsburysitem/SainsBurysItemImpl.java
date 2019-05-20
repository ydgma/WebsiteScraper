package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SainsBurysItemImpl implements SainsBurysItem {
    private static final Logger LOG = LoggerFactory.getLogger(SainsBurysItem.class);
    private static final String INITIAL_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/";
    private Element element;
    private SainsBurysItemInfo sainsBurysItemInfo;

    public SainsBurysItemImpl(Element element) {
        this.element = element;
        sainsBurysItemInfo = new SainsBurysItemInfoImpl(createItemInfoUrl());
    }

    private String createItemInfoUrl() {
        String extractedHTML = element.getElementsByClass("productNameAndPromotions").first().html();
        String regex = "\">.*|\\../|.*?f=\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(extractedHTML);
        extractedHTML = matcher.replaceAll("");

        return INITIAL_URL + extractedHTML;
    }

    @Override
    public String getTitle() {
        return element.getElementsByClass("productNameAndPromotions")
                .first()
                .text();
    }

    @Override
    public Optional<String> getKcal_per_100g() {
        return sainsBurysItemInfo.getKclper100g();
    }

    @Override
    public BigDecimal getUnit_price() {
        String priceInString = element.getElementsByClass("pricePerUnit")
                .first()
                .text();

        priceInString = priceInString.replaceAll("[^\\d.]", "");

        return new BigDecimal(priceInString);
    }

    @Override
    public Optional<String> getDescription() {
        return sainsBurysItemInfo.getDescription();
    }

    @Override
    public Element getElement() {
        return element;
    }
}
