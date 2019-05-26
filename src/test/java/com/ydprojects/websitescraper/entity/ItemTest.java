package com.ydprojects.websitescraper.entity;

import com.ydprojects.websitescraper.entity.data.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@PrepareForTest(Item.class)
@RunWith(PowerMockRunner.class)
public class ItemTest {

    private Item item;
    private BigDecimal decimal = new BigDecimal(1);

    @Before
    public void SetUp() throws Exception {
        item = Mockito.mock(Item.class);
        PowerMockito.whenNew(Item.class).withAnyArguments().thenReturn(item);
    }

    @Test
    public void testGetTitle() {
        String expected = "title";

        PowerMockito.when(item.getTitle()).thenReturn(expected);
        assertEquals(expected, item.getTitle());
    }

    @Test
    public void testGetUnitPrice() {
        PowerMockito.when(item.getUnit_price()).thenReturn(decimal);
        assertEquals(decimal, item.getUnit_price());
    }

    @Test
    public void testGetDescription() {
        String expected = "description";

        PowerMockito.when(item.getDescription()).thenReturn(expected);
        assertEquals(expected, item.getDescription());
    }

    @Test
    public void testGetKcalPer100g() {

        Integer expected = 1;

        PowerMockito.when(item.getKcal_per_100g()).thenReturn(expected);
        assertEquals(expected, item.getKcal_per_100g());
    }
}
