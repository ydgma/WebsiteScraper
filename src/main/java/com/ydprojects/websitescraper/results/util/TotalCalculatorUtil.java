package com.ydprojects.websitescraper.results.util;

import com.ydprojects.websitescraper.entity.data.Item;

import java.math.BigDecimal;
import java.util.List;

public class TotalCalculatorUtil {

    private TotalCalculatorUtil() {

    }

    public static BigDecimal calculateGross(List<Item> listOfItems) {
        BigDecimal initial = new BigDecimal(0);

        for (Item item : listOfItems) {
            BigDecimal fromNewITem = item.getUnit_price();
            initial = initial.add(fromNewITem);
        }

        BigDecimal gross = initial.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return gross;
    }

    public static BigDecimal calculateVat(BigDecimal gross) {
        BigDecimal vatPercentage = new BigDecimal(1.20);
        BigDecimal vat = gross.divide(vatPercentage, 2, BigDecimal.ROUND_HALF_EVEN);
        vat = vat.subtract(gross).multiply(new BigDecimal(-1));

        BigDecimal vatRounded = vat.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return vatRounded;
    }
}