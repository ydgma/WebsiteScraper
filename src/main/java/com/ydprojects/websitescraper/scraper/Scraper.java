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

/**
 * Class is used to scrape elements from and a document and return child elements/child element text
 */
public class Scraper {
    private static final Logger LOG = LoggerFactory.getLogger(Scraper.class);
    private static final String TAG_NAME = "p";
    private Document document;
    private String url;

    public Scraper(String url) {
        this.url = Objects.requireNonNull(url, "url cannot be null");
        getDocumentFromUrl();
    }


    public Document getPage() {
        return document;
    }

    /**
     * Gets a list of child classes from a document by filtering though parent Id and child class name
     *
     * @param parentClassId  Id of the parent element
     * @param childClassName name of the child class residing within the parent
     * @return list of elements with the child
     */
    public List<Element> getChildClassesFromParentByParentIdAndChildName(String parentClassId, String childClassName) {
        List<Element> listOfChildClasses;

        listOfChildClasses = document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return listOfChildClasses;

    }

    /**
     * Gets text from a child element by filtering the child elements with part of the expected text
     *
     * @param parentClassId  Id of the parent element
     * @param childClassName name of the child class residing within the parent
     * @param textToContain  part of the text to be expected in the child element
     * @return an optional with the child text if present or an empty optional instance
     */
    public Optional<String> getTextFromAChildByUsingParentAndPartOfExpectedText(String parentClassId, String childClassName, String textToContain) {
        return document.getElementById(parentClassId).getElementsByClass(childClassName)
                .stream()
                .filter(Objects::nonNull)
                .filter(element -> element.text().contains(textToContain))
                .findFirst()
                .map(Element::text);
    }

    /**
     * Returns the first piece of text with '<p>' tag from a child class
     *
     * @param parentClassId  Id of the parent element
     * @param childClassName name of the child class residing within the parent
     * @return an optional with the child text if present or an empty optional instance
     */
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
        } catch (IllegalArgumentException | HttpStatusException e) {
            throw new RuntimeException("Application failed to start with the the URL :" + url + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
