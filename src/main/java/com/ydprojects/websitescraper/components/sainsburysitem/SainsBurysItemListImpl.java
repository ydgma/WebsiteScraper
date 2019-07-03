package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.scraper.Scraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SainsBurysItemListImpl implements SainsBurysItemList {
    private static final Logger LOG = LoggerFactory.getLogger(SainsBurysItemListImpl.class);
    private Scraper scraper;
    private List<SainsBurysItemImpl> sainsBurysItemImplList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    public SainsBurysItemListImpl(String pageUrl) {
        Objects.requireNonNull(pageUrl,"pageUrl cannot be null");
        this.scraper = new Scraper(pageUrl);
        populateItemListImpl();
    }

    private void populateItemListImpl() {
        scraper.getChildClassesFromParentByParentIdAndChildName("productLister", "gridItem")
                .forEach(element -> sainsBurysItemImplList.add(new SainsBurysItemImpl(element)));
    }

    @Override
    public List<Item> getItemList() {
        sainsBurysItemImplList
                .stream()
                .forEach(i -> itemList.add(new Item(i)));
        return itemList;
    }


}
