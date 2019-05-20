package com.ydprojects.websitescraper.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.results.builder.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JasonMapperUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JasonMapperUtil.class);
    private static ObjectMapper mapper = new ObjectMapper();

    private JasonMapperUtil() {

    }

    public static String getResultsAsAJasonString(Results results) {
        String returnString = "";
        try {
            returnString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(results);
        } catch (JsonProcessingException e) {
            LOG.info("{}", e);
        }
        return !returnString.equals("") ? returnString : "returned an empty string see logs for details";
    }

    public static String getItemAsAJasonString(Item item) {
        String returnString = "";
        try {
            returnString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(item);
        } catch (JsonProcessingException e) {
            LOG.info("{}", e);
        }
        return !returnString.equals("") ? returnString : "returned an empty string see logs for details";
    }


}
