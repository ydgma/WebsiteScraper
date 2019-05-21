package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Optional;

public class SainsBurysItemImpl implements SainsBurysItem {
    private static final Logger LOG = LoggerFactory.getLogger(SainsBurysItem.class);

    private Element element;
    private SainsBurysItemInfo sainsBurysItemInfo;

    public SainsBurysItemImpl(Element element) {
        this.element = element;
        sainsBurysItemInfo = new SainsBurysItemInfoImpl(createItemInfoUrl());
    }

    private String createItemInfoUrl() {
        return element.getElementsByClass("productNameAndPromotions")
                .first()
                .getElementsByTag("h3")
                .first()
                .childNodes().stream()
                .filter(node -> node.attributes().hasKey("href"))
                .findFirst()
                .map(node -> node.attr("abs:href"))
                .get();
    }

    @Override
    public String getTitle() {
        return element.getElementsByClass("productNameAndPromotions")
                .first()
                .text();
    }

    @Override
    public Optional<Integer> getKcal_per_100g() {
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
