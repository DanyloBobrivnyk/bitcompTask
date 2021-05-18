package com.bitcomp.parser.dom;

import com.bitcomp.entity.ParseResult;
import com.bitcomp.parser.ParserFields;
import com.bitcomp.parser.ParserFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.HashMap;

public class DOMParser {

    public static ParseResult parse(String source, String formatName) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(source);

        ParserFormat parserFormat = new ParserFormat(formatName);
        return DOMParser.parse(doc, parserFormat);
    }

    private static ParseResult parse(Document doc, ParserFormat parserFormat) throws JsonProcessingException
    {
        NodeList list = doc.getElementsByTagName(parserFormat.getParentNodeName());
        ParseResult parseResult = new ParseResult();

        for(int i = 0; i < list.getLength(); i++)
        {
            Node nodeItem = list.item(i);
            if(nodeItem.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) nodeItem;

                HashMap<ParserFields, String> childNodesHashMap = parserFormat.getParentNodeChildNodes();

                StringBuilder stringBuilder = new StringBuilder("{");

                for(ParserFields p : ParserFields.values())
                {
                    if(childNodesHashMap.get(p) != null)
                    {
                        String name = childNodesHashMap.get(p);

                        if(getElementContextByName(name, element).equalsIgnoreCase("no_value"))
                        {
                            buildJsonValue(stringBuilder, p.toString(), "no_value");
                        }
                        else
                        {
                            buildJsonValue(stringBuilder, p.toString(), getElementContextByName(name, element));
                        }
                    }
                }
                String json = stringBuilder.substring(0, stringBuilder.length() - 2) + "}";

                parseResult = new ObjectMapper().readValue(json, ParseResult.class);
            }
        }
        return parseResult;
    }

    private static void buildJsonValue(StringBuilder stringBuilder,String key, String value)
    {
        stringBuilder
                .append(enquote(key))
                .append(" : ")
                .append(enquote(value))
                .append(", ");
    }

    private static String enquote(String value){return "\"" + value + "\"";}

    public static String getElementContextByName(String elementName, Element element)
    {
        try
        {
            return element.getElementsByTagName(elementName).item(0).getTextContent();
        }
        catch (Exception e)
        {
            return "no_value";
        }
    }
}
