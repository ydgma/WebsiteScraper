package com.ydprojects.websitescraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class Scraper {
    private static final Logger LOG = LoggerFactory.getLogger(Scraper.class);

    private Document document;

    public Scraper(String url) {

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            LOG.info("{}", e);
        }

    }

    public Document getPage() {
        return document;
    }


}
