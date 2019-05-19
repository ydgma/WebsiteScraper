package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.scraper.Scraper;

import java.util.Optional;

public class SainsBurysItemInfoImpl implements SainsBurysItemInfo{

    Scraper scraper;
    private static final String PARENT_CLASS_ID = "information";

    public SainsBurysItemInfoImpl (String url) {
        scraper = new Scraper(url);
    }

    @Override
    public Optional<String> getKclper100g() {

        Optional <String> optional = scraper.getChildClassContainingTextByParentId(PARENT_CLASS_ID,"nutritionLevel1","kcal");

        return optional.map(s -> s.replaceAll("[^\\d]", ""));
    }

    @Override
    public Optional<String> getDescription() {
        return scraper.getChildClassContainingTextByParentId(PARENT_CLASS_ID,"productText","by Sainsbury's");

    }
}
