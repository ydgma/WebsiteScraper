package com.ydprojects.websitescraper.scraper;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public class Scraper {
    private static final Logger LOG = LoggerFactory.getLogger(Scraper.class);
    private static final String TAG_NAME = "p";
    private Document document;
    private String url;

    public Scraper(String url) {
        this.url = Objects.requireNonNull(url,"url cannot be null");
        getDocumentFromUrl();
    }

    public Document getPage() {
        return document;
    }

    public List<Element> getChildClassesFromParentByParentIdAndChildName(String parentClassId, String childClassName) {
        List<Element> listOfChildClasses;

        listOfChildClasses = document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return listOfChildClasses;

    }

    public Optional<String> getChildClassContainingTextByParentId(String parentClassId, String childClassName, String textToContain) {
        return document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(Objects::nonNull)
                .filter(element -> element.text().contains(textToContain))
                .findFirst()
                .map(Element::text);
    }

    public Optional<String> getFirstParagraphFromAChildClass(String parentClassId, String childClassName) {
        return document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .map(element -> element.getElementsByTag(TAG_NAME)
                        .stream()
                        .map(element1 -> element1.getElementsByTag(TAG_NAME))
                        .filter(Elements::hasText)
                        .findFirst()
                        .map(Elements::text)).get();

    }

    private void getDocumentFromUrl() {
        try {
            document = Jsoup.connect(url).get();
        }
        catch (IllegalArgumentException  | HttpStatusException e) {
            throw new RuntimeException("Application failed to start with the the URL :" + url + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
