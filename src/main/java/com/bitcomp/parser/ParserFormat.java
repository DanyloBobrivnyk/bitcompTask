package com.bitcomp.parser;

import java.util.HashMap;

public class ParserFormat {
    private String parentNode;

    private HashMap<ParserFields, String> childNodes = new HashMap<>();

    public ParserFormat(String formatType)
    {
        switch (formatType)
        {
            case "aaa":
                defineFormatDependencies("Flurstueck", "flstkennz", "flaeche",
                        "landschl", "kreisschl", "gmdschl",
                        "gemaschl");
                break;
            case "nas":
                defineFormatDependencies("AX_Flurstueck","flurstueckskennzeichen","amtlicheFlaeche",
                        "land", "kreis", "gemeinde",
                        "gemarkungsnummer");
                break;
            default:
                System.out.println("Parse Format default statement invoked...");
                break;
        }
    }

    public String getParentNodeName()
    {
        return parentNode;
    }

    public HashMap<ParserFields, String> getParentNodeChildNodes()
    {
        return childNodes;
    }

    private void defineFormatDependencies(String parentNode, String areaNumber, String areaSize,
                                          String landNumber, String precinctNumber, String districtNumber,
                                          String geoMarkNumber)
    {
        this.parentNode = parentNode;

        childNodes.put(ParserFields.AREA_NUMBER, areaNumber);
        childNodes.put(ParserFields.AREA_SIZE, areaSize);
        childNodes.put(ParserFields.LAND_NUMBER, landNumber);
        childNodes.put(ParserFields.PRECINCT_NUMBER, precinctNumber);
        childNodes.put(ParserFields.DISTRICT_NUMBER, districtNumber);
        childNodes.put(ParserFields.GEO_MARK_NUMBER, geoMarkNumber);
    }
}
