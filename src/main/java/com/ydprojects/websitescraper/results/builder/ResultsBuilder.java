package com.ydprojects.websitescraper.results.builder;

import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItem;
import com.ydprojects.websitescraper.components.sainsburysitem.SainsBurysItemImpl;

import java.util.List;

public class ResultsBuilder {
    private List<SainsBurysItemImpl> listOfItems;


    public ResultsBuilder(List<SainsBurysItemImpl> listOfItems) {
        this.listOfItems = listOfItems;
    }


}
