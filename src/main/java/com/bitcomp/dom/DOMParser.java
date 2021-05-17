package com.bitcomp.dom;

import com.bitcomp.ParserFields;
import com.bitcomp.ParserFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.HashMap;

public class DOMParser {

    public static void parse(String source, String formatName) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(source);

        ParserFormat parserFormat = new ParserFormat(formatName);
        DOMParser.parse(doc, parserFormat);
    }

    private static void parse(Document doc, ParserFormat parserFormat)
    {
        NodeList list = doc.getElementsByTagName(parserFormat.getParentNodeName());

        for(int i = 0; i < list.getLength(); i++)
        {
            Node nodeItem = list.item(i);
            if(nodeItem.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) nodeItem;
                //TODO: Check for some exceptions
                HashMap<ParserFields, String> childNodesHashMap = parserFormat.getParentNodeChildNodes();

                //Write all the fields from hashmap to the console.
                for(ParserFields p : ParserFields.values())
                {
                    if(childNodesHashMap.get(p) != null)
                    {
                        String name = childNodesHashMap.get(p);
                        System.out.println(p.toString() + "/ " + name + ": "
                                + getElementContextByName(name, element) + ";");
                    }
                }
            }
        }
    }

    public static String getElementContextByName(String elementName, Element element)
    {
        return element.getElementsByTagName(elementName).item(0).getTextContent();
    }
}
