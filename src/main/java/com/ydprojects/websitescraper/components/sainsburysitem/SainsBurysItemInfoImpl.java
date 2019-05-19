package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.scraper.Scraper;

public class SainsBurysItemInfoImpl implements SainsBurysItemInfo{

    Scraper scraper;

    public SainsBurysItemInfoImpl (String url) {
        scraper = new Scraper(url);
    }

    @Override
    public String getKclper100g() {
       return scraper.getChildClassWithTextContaining("information","nutritionLevel1","kcal").text();
    }

    @Override
    public String getDescription() {
        return scraper.getChildClassContainingTextByParentId("information","productText","by Sainsbury's").text();
    }
}
