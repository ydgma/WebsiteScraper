package com.ydprojects.websitescraper.results;

import com.ydprojects.websitescraper.entity.data.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest({Results.class, Item.class})
@RunWith(PowerMockRunner.class)
public class ResultsTest {

    private Results results;
    private Item item;
    private List<Item> listOfItems;
    private Map<String, BigDecimal> total;

    @Before
    public void setUp() throws Exception {
        results = mockClasses(Results.class);
        item = mockClasses(Item.class);
        listOfItems = Arrays.asList(item, item);
        total = new HashMap<>();
        total.put("key", new BigDecimal(1));
    }

    public <T> T mockClasses(Class<T> clazz) throws Exception {
        T mockObject;

        mockObject = mock(clazz);
        whenNew(clazz).withAnyArguments().thenReturn(mockObject);

        return mockObject;
    }

    @Test
    public void testGetItemList() {
        when(results.getResults()).thenReturn(listOfItems);
        assertEquals(listOfItems, results.getResults());
    }

    @Test
    public void testGetTotal() {
        when(results.getTotal()).thenReturn(total);
        assertEquals(total, results.getTotal());
    }

    @Test
    public void testGetResultsAsJason() {
        String expected = "Json result";

        when(results.getResultsAsJason()).thenReturn(expected);
        assertEquals(expected, results.getResultsAsJason());
    }


}
