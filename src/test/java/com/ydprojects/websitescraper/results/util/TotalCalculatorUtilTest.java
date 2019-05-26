package com.ydprojects.websitescraper.results.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;

@PrepareForTest({TotalCalculatorUtil.class})
@RunWith(PowerMockRunner.class)
public class TotalCalculatorUtilTest {
    private List<BigDecimal> listOfBigDecimals = new ArrayList<>();
    private BigDecimal decimal = new BigDecimal(15).setScale(2, BigDecimal.ROUND_HALF_EVEN);

    @Before
    public void setUp() {
        PowerMockito.mockStatic(TotalCalculatorUtil.class);
        listOfBigDecimals.add(decimal);
    }

    @Test
    public void testCalculateGross() {

        PowerMockito.when(TotalCalculatorUtil.calculateGross(anyListOf(BigDecimal.class))).thenReturn(decimal);

        assertEquals(decimal, TotalCalculatorUtil.calculateGross(listOfBigDecimals));
    }

    @Test
    public void testCalculateVat() {

        PowerMockito.when(TotalCalculatorUtil.calculateVat(any(BigDecimal.class))).thenReturn(decimal);

        assertEquals(decimal, TotalCalculatorUtil.calculateVat(decimal));
    }

}
