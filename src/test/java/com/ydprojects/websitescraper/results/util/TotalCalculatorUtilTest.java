package com.ydprojects.websitescraper.results.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TotalCalculatorUtilTest {

    @Test
    public void testCalculateGross() {

        List<BigDecimal> listOfValues = new ArrayList<>();
        listOfValues.add(new BigDecimal(5));
        listOfValues.add(new BigDecimal(5));
        listOfValues.add(new BigDecimal(5));


        BigDecimal outPut = TotalCalculatorUtil.calculateGross(listOfValues);

        assertEquals(new BigDecimal(15).setScale(2,BigDecimal.ROUND_HALF_EVEN),outPut);
    }

    @Test
    public void testCalculateVat() {
        BigDecimal gross = new BigDecimal(5);

        BigDecimal vat = TotalCalculatorUtil.calculateVat(gross);

        assertEquals(new BigDecimal(0.83).setScale(2,BigDecimal.ROUND_HALF_EVEN),vat);
    }

}
