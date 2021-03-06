package com.ydprojects.websitescraper.entity.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.results.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JasonMapperUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JasonMapperUtil.class);
    private static ObjectMapper mapper = new ObjectMapper();

    private JasonMapperUtil() {
        // hiding public constructor
    }

    public static String getResultsAsAJsonString(Results results) {
        // setting indentation between elements in the array
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        CustomPrettyPrinter prettyPrinter = new CustomPrettyPrinter();

        String returnString = "";
        try {
            returnString = mapper.writer(prettyPrinter).writeValueAsString(results);
        } catch (JsonProcessingException e) {
            LOG.info("Could not parse the Json String {}", e);
        }
        return returnString;
    }

    public static String getItemAsAJsonString(Item item) {
        String returnString = "";
        try {
            returnString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
        } catch (JsonProcessingException e) {
            LOG.info("Could not parse the Json String {}", e);
        }
        return returnString;
    }


}
