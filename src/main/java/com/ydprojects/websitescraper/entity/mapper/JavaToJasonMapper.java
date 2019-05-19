package com.ydprojects.websitescraper.entity.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ydprojects.websitescraper.results.builder.ResultsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JavaToJasonMapper {
    private static final Logger LOG = LoggerFactory.getLogger(JavaToJasonMapper.class);
    //rivate final String REGEX = "(\"kcal_per_100g\" : \"\",)";

    public JavaToJasonMapper() throws IOException {
      ObjectMapper mapper = new ObjectMapper();

      ResultsBuilder resultsBuilder = new ResultsBuilder();

      LOG.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultsBuilder));

     // LOG.info(REGEX);
    }








}
