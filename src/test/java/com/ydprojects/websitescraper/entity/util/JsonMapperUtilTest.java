package com.ydprojects.websitescraper.entity.util;

import com.ydprojects.websitescraper.entity.data.Item;
import com.ydprojects.websitescraper.results.Results;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JasonMapperUtil.class)
public class JsonMapperUtilTest {

    private Results results;
    private Item item;

    @Before
    public void setUp() {
        results = mockClasses(Results.class);
        item = mockClasses(Item.class);
        mockStatic(JasonMapperUtil.class);
    }

    public <T> T mockClasses(Class<T> clazz) {
        T object;
        object = mock(clazz);

        return object;

    }

    @Test
    public void testGetResultsAsJasonString() {
        String result = "Result";

        when(JasonMapperUtil.getResultsAsAJsonString(any(Results.class))).thenReturn(result);
        assertEquals(result, JasonMapperUtil.getResultsAsAJsonString(results));
    }

    @Test
    public void testGetItemAsAJsonString() {
        String expected = "Item";

        when(JasonMapperUtil.getItemAsAJsonString(any(Item.class))).thenReturn(expected);
        assertEquals(expected, JasonMapperUtil.getItemAsAJsonString(item));
    }
}
