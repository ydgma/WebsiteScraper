package com.ydprojects.websitescraper.components.sainsburysitem;

import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@RunWith(PowerMockRunner.class)
@PrepareForTest({SainsBurysItemImpl.class, Element.class})
public class SainsBurysItemImplTest {

    private SainsBurysItemImpl sainsBurysItemImpl;
    private Element element;
    private BigDecimal decimal = new BigDecimal(5);


    @Before
    public void before() throws Exception {
        sainsBurysItemImpl = setUpMocks(SainsBurysItemImpl.class);
        element = setUpMocks(Element.class);
    }

    private <T> T setUpMocks(Class<T> clazz) throws Exception {

        T object;

        object = Mockito.mock(clazz);
        whenNew(clazz).withAnyArguments().thenReturn(object);

        return object;
    }

    @Test
    public void testGetTitle() {
        String expected = "title";

        when(sainsBurysItemImpl.getTitle()).thenReturn(expected);
        assertEquals(expected, sainsBurysItemImpl.getTitle());
    }

    @Test
    public void testGetKclPer100g() {
        when(sainsBurysItemImpl.getKcal_per_100g()).thenReturn(Optional.of(1));
        assertEquals(Optional.of(1), sainsBurysItemImpl.getKcal_per_100g());
    }

    @Test
    public void testGetDescription() {
        String expected = "description";

        when(sainsBurysItemImpl.getDescription()).thenReturn(Optional.of(expected));
        assertEquals(Optional.of(expected), sainsBurysItemImpl.getDescription());
    }

    @Test
    public void testGetUnitPrice() {
        when(sainsBurysItemImpl.getUnit_price()).thenReturn(decimal);
        assertEquals(decimal, sainsBurysItemImpl.getUnit_price());
    }

    @Test
    public void testGetElement() {
        when(sainsBurysItemImpl.getElement()).thenReturn(element);
        assertEquals(element, sainsBurysItemImpl.getElement());

    }

}
