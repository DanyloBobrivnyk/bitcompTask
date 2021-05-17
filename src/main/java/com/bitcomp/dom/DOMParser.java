package com.bitcomp.dom;

import com.bitcomp.ParserFields;
import com.bitcomp.ParserFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

public class DOMParser {

    public static void parse(Document doc, ParserFormat parserFormat)
    {
        NodeList list = doc.getElementsByTagName(parserFormat.getParentNodeName());

        for(int i = 0; i < list.getLength(); i++)
        {
            Node nodeItem = list.item(i);
            if(nodeItem.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) nodeItem;
                //may be thrown exception
                HashMap<ParserFields, String> childNodesHashMap = parserFormat.getParentNodeChildNodes();

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
