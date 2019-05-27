package com.ydprojects.websitescraper.scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest({Scraper.class})
@RunWith(PowerMockRunner.class)
public class ScraperTest {

    private Scraper scraper;
    private Element element;
    private Document document;
    private List<Element> listOfElements;
    private Optional<String> result = Optional.of("result");
    private String parentId = "parentId";
    private String childClassName = "childName";


    @Before
    public void setUp() throws Exception {
        scraper = mockClasses(Scraper.class);
        element = mockClasses(Element.class);
        document = mockClasses(Document.class);
        listOfElements = Arrays.asList(element, element);
    }

    private <T> T mockClasses(Class<T> clazz) throws Exception {
        T object;

        object = Mockito.mock(clazz);
        whenNew(clazz).withAnyArguments().thenReturn(object);

        return object;

    }

    @Test
    public void getDocumentTest() {
        when(scraper.getPage()).thenReturn(document);
        assertEquals(document, scraper.getPage());
    }

    @Test
    public void testGetChildClasses() {
        when(scraper.getChildClassesFromParentByParentIdAndChildName(anyString(), anyString())).thenReturn(listOfElements);
        assertEquals(listOfElements, scraper.getChildClassesFromParentByParentIdAndChildName(parentId, childClassName));
    }

    @Test
    public void testGetChildClassContainingTextByParentId() {
        when(scraper.getTextFromAChildByUsingParentAndPartOfExpectedText(anyString(), anyString(), anyString())).thenReturn(result);
        assertEquals(result, scraper.getTextFromAChildByUsingParentAndPartOfExpectedText(parentId, childClassName, "textToContain"));
    }

    @Test
    public void testGetFirstParagraphFromAChildClass() {
        when(scraper.getFirstParagraphFromAChildClass(anyString(), anyString())).thenReturn(result);
        assertEquals(result, scraper.getFirstParagraphFromAChildClass(parentId, childClassName));
    }


}
