package com.ydprojects.websitescraper.components.sainsburysitem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SainsBurysItemListImpl.class})
public class SainsBurysItemListImplTest {

    private SainsBurysItemListImpl sainsBurysItemListImpl;
    private SainsBurysItemImpl sainsBurysItemImpl;
    private List<SainsBurysItemImpl> listOfItems;


    @Before
    public void setUp() throws Exception {
        sainsBurysItemListImpl = setUpMocks(SainsBurysItemListImpl.class);
        sainsBurysItemImpl = setUpMocks(SainsBurysItemImpl.class);
        listOfItems = Arrays.asList(sainsBurysItemImpl, sainsBurysItemImpl);
    }

    private <T> T setUpMocks(Class<T> clazz) throws Exception {
        T object;

        object = Mockito.mock(clazz);
        whenNew(clazz).withAnyArguments().thenReturn(object);

        return object;
    }

    @Test
    public void testGetLists() {
        when(sainsBurysItemListImpl.getItemList()).thenReturn(listOfItems);
        assertEquals(listOfItems, sainsBurysItemListImpl.getItemList());
    }


}
