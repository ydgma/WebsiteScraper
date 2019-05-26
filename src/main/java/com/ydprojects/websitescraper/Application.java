package com.ydprojects.websitescraper;


import com.ydprojects.websitescraper.entity.util.JasonMapperUtil;
import com.ydprojects.websitescraper.results.Results;

public class Application {
    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {
        Results results = new Results(URL);
        System.out.println(JasonMapperUtil.getResultsAsAJsonString(results));
    }
}
