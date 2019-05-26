package com.ydprojects.websitescraper.components.sainsburysitem;


import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SainsBurysItemInfoImpl.class, Element.class})
public class SainsBurysItemInfoImplTest {

    private SainsBurysItemInfoImpl sainsBurysItemInfoImpl;

    @Before
    public void setUp() throws Exception {
        sainsBurysItemInfoImpl = Mockito.mock(SainsBurysItemInfoImpl.class);
        whenNew(SainsBurysItemInfoImpl.class).withAnyArguments().thenReturn(sainsBurysItemInfoImpl);
    }

    @Test
    public void testGetKclPer100g() {
        Optional<Integer> expected = Optional.of(1);

        when(sainsBurysItemInfoImpl.getKclper100g()).thenReturn(expected);
        assertEquals(expected, sainsBurysItemInfoImpl.getKclper100g());
    }

    @Test
    public void testGetDescription() {
        Optional<String> expected = Optional.of("string");

        when(sainsBurysItemInfoImpl.getDescription()).thenReturn(expected);
        assertEquals(expected, sainsBurysItemInfoImpl.getDescription());
    }


}
