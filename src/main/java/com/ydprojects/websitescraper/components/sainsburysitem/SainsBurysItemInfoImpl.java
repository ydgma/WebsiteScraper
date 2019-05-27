package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.scraper.Scraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

public class SainsBurysItemInfoImpl implements SainsBurysItemInfo {
    private static final Logger LOG = LoggerFactory.getLogger(SainsBurysItemInfoImpl.class);
    private static final String PARENT_CLASS_ID = "information";
    private Scraper scraper;

    public SainsBurysItemInfoImpl(String url) {
        Objects.requireNonNull(url,"url cannot be null");
        scraper = new Scraper(url);
    }

    @Override
    public Optional<Integer> getKclper100g() {
        Optional<String> optional = scraper.getTextFromAChildByUsingParentAndPartOfExpectedText(PARENT_CLASS_ID, "tableRow0", "kcal");

        return optional.map(s -> Integer.parseInt(s.replaceAll("kcal.*", "")));
    }

    @Override
    public Optional<String> getDescription() {
        return scraper.getFirstParagraphFromAChildClass(PARENT_CLASS_ID, "productText");
    }
}
