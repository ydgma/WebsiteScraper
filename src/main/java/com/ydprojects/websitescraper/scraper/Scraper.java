package com.ydprojects.websitescraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scraper {
    private static final Logger LOG = LoggerFactory.getLogger(Scraper.class);
    private Function<List<Element>,Element> getElement = (k) -> k.stream()
            .findFirst()
            .get();

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


}
