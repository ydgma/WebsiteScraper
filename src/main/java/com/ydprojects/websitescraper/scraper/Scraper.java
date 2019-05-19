package com.ydprojects.websitescraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Scraper {
    private static final Logger LOG = LoggerFactory.getLogger(Scraper.class);
    private Document document;
    private static final String TAG_NAME = "p";

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

    public List<Element> getChildClasses(String parentClassId, String childClassName) {
        List<Element> listOfChildClasses;

        listOfChildClasses = new ArrayList<>(document.getElementById(parentClassId)
                .getElementsByClass(childClassName));

        return listOfChildClasses;

    }

    public Optional<String> getChildClassContainingTextByParentId(String parentClassId, String childClassName,String textToContain) {
        return document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(element -> element.text().contains(textToContain))
                .findFirst()
                .map(Element::text);
    }

    public Optional<String> getFIrstParagraphFromAChildClass(String parentClassId, String childClassName) {
        return document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .findFirst()
                .map(element -> element.getElementsByTag(TAG_NAME)
                        .stream()
                        .map(element1 -> element1.getElementsByTag(TAG_NAME))
                        .filter(Elements::hasText)
                        .findFirst()
                        .map(Elements::text)).get();

    }

}
