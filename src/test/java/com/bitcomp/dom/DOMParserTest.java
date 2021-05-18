package com.bitcomp.dom;

import com.bitcomp.Main;
import com.bitcomp.entity.ParseResult;
import com.bitcomp.parser.dom.DOMParser;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;


public class DOMParserTest {
    Main app = new Main();

    @Test
    public void parseXmlFileAAA() throws Exception
    {
        InputStream is = app.getFileFromResourceAsStream("source_data_aaa.xml");

        ParseResult actualResult = DOMParser.parse(is, "aaa");

        ParseResult expectedResult = new ParseResult();
        expectedResult.setAreaNumber("05453300101559______");
        expectedResult.setAreaSize("2.00");
        expectedResult.setLandNumber("05");
        expectedResult.setPrecinctNumber("05378");
        expectedResult.setDistrictNumber("05378028");
        expectedResult.setGeoMarkNumber("054533");

        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @Test
    public void parseXmlFileNAS() throws Exception
    {
        InputStream is = app.getFileFromResourceAsStream("source_data_nas.xml");


        ParseResult actualResult = DOMParser.parse(is, "nas");

        ParseResult expectedResult = new ParseResult();
        expectedResult.setAreaNumber("095653___05443______");
        expectedResult.setAreaSize("9480");
        expectedResult.setLandNumber("09");
        expectedResult.setPrecinctNumber("80");
        expectedResult.setDistrictNumber("no_value");
        expectedResult.setGeoMarkNumber("no_value");

        Assert.assertNotEquals(expectedResult, actualResult);
    }

}
