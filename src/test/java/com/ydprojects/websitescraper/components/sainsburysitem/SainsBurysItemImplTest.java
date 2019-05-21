package com.ydprojects.websitescraper.components.sainsburysitem;

import com.ydprojects.websitescraper.scraper.Scraper;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.Optional;


@RunWith(PowerMockRunner.class)
@PrepareForTest({SainsBurysItemImpl.class, Element.class})
public class SainsBurysItemImplTest {

    private SainsBurysItemImpl sainsBurysItemImplMock;
    private Element elementMock;
    private BigDecimal decimal = new BigDecimal(5);


    @Before
    public void before() throws Exception {
        setUp();
    }

    private void setUp() throws Exception {
         sainsBurysItemImplMock = Mockito.mock(SainsBurysItemImpl.class);
         PowerMockito.whenNew(SainsBurysItemImpl.class).withAnyArguments().thenReturn(sainsBurysItemImplMock);

         elementMock = Mockito.mock(Element.class);
         PowerMockito.whenNew(Element.class).withAnyArguments().thenReturn(elementMock);
    }

    @Test
    public void testGetTitle() {
        PowerMockito.when(sainsBurysItemImplMock.getTitle()).thenReturn("title");
        Assert.assertEquals("title", sainsBurysItemImplMock.getTitle());
    }

    @Test
    public void testGetKclPer100g() {
        PowerMockito.when(sainsBurysItemImplMock.getKcal_per_100g()).thenReturn(Optional.of(1));
        Assert.assertEquals(Optional.of(1), sainsBurysItemImplMock.getKcal_per_100g());
    }

    @Test
    public void testGetDescription() {
        PowerMockito.when(sainsBurysItemImplMock.getDescription()).thenReturn(Optional.of("description"));
        Assert.assertEquals(Optional.of("description"), sainsBurysItemImplMock.getDescription());
    }

    @Test
    public void testGetUnitPrice() {
        PowerMockito.when(sainsBurysItemImplMock.getUnit_price()).thenReturn(decimal);
        Assert.assertEquals(decimal,sainsBurysItemImplMock.getUnit_price());
    }

    @Test
    public void testGetElement() {
        PowerMockito.when(sainsBurysItemImplMock.getElement()).thenReturn(elementMock);
        Assert.assertEquals(elementMock,sainsBurysItemImplMock.getElement());

    }



}
