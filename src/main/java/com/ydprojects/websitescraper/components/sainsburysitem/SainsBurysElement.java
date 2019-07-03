package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;


public class SainsBurysElement extends Element {

    public SainsBurysElement(Tag tag, String baseUri, Attributes attributes) {
        super(tag, baseUri, attributes);
    }

    public SainsBurysElement(Tag tag, String baseUri) {
        super(tag, baseUri);
    }

    public Element getElement() {
      return this.getElement();
    }

}
