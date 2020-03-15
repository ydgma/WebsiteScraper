package com.ydprojects.websitescraper;

import com.ydprojects.websitescraper.results.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {
        LOG.trace("Creating a list of items with the url {}", URL);
        Results results = new Results(URL);
        System.out.println(results.getResultsAsJason());
    }
}
