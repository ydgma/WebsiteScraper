package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.scraper.Scraper;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SainsBurysItemListImpl implements SainsBurysItemList {
    private static final Logger LOG = LoggerFactory.getLogger(SainsBurysItemListImpl.class);
    private final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    private Document document;
    private List<SainsBurysItem> listOfItems = new ArrayList<>();
    Scraper scraper;

    public SainsBurysItemListImpl() {
        this.scraper = new Scraper(URL);
        this.document = scraper.getPage();
    }

    public SainsBurysItemListImpl(Document document) {
        this.document = document;
    }

    private void populateItemList() {
        scraper.getChildClasses("productLister","gridItem")
                .forEach(element -> {
                    listOfItems.add(new SainsBurysItemImpl(element));
                });
    }

    @Override
    public List<SainsBurysItem> getItemList() {
        populateItemList();
        return listOfItems;
    }


}
