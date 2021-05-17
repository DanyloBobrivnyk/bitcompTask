package com.bitcomp.dom;

import com.bitcomp.parser.dom.DOMParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;


public class DOMParserTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp()
    {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void parseXmlFile()
    {
        String source = "src/test/resources/source_data_aaa.xml";
        String expected = "AREA_NUMBER/ flstkennz: 123456789_;" +
                "AREA_SIZE/ flaeche: 2.00;" +
                "LAND_NUMBER/ landschl: 05;" +
                "PRECINCT_NUMBER/ kreisschl: 05378;" +
                "DISTRICT_NUMBER/ gmdschl: 05378028;" +
                "GEO_MARK_NUMBER/ gemaschl: 054533;";
        try
        {
            DOMParser.parse(source, "aaa");
            Assert.assertEquals(clearString(expected), clearString(outputStreamCaptor.toString()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private String clearString(String str)
    {
        return str.toLowerCase(Locale.ROOT).replace(System.getProperty("line.separator"), "").trim();
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
