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

        Optional <String> optional = scraper.getChildClassContainingTextByParentId(PARENT_CLASS_ID,"tableRow0","kcal");

        return optional.map(s -> s.replaceAll("kcal.*", ""));
    }

    @Override
    public Optional<String> getDescription() {
        return scraper.getFIrstParagraphFromAChildClass(PARENT_CLASS_ID,"productText");


    }
}
