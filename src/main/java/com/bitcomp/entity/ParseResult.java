package com.bitcomp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParseResult {

    public ParseResult() {
    }

    private String areaNumber;
    private String areaSize;
    private String landNumber;
    private String precinctNumber;
    private String districtNumber;
    private String geoMarkNumber;

    @JsonProperty("AREA_NUMBER")
    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }

    @JsonProperty("AREA_SIZE")
    public String getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }

    @JsonProperty("LAND_NUMBER")
    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    @JsonProperty("PRECINCT_NUMBER")
    public String getPrecinctNumber() {
        return precinctNumber;
    }

    public void setPrecinctNumber(String precinctNumber) {
        this.precinctNumber = precinctNumber;
    }

    @JsonProperty("DISTRICT_NUMBER")
    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    @JsonProperty("GEO_MARK_NUMBER")
    public String getGeoMarkNumber() {
        return geoMarkNumber;
    }

    public void setGeoMarkNumber(String geoMarkNumber) {
        this.geoMarkNumber = geoMarkNumber;
    }

    @Override
    public String toString() {
        return "ParseResult{" + "areaNumber='" + areaNumber + '\''
                + ", areaSize='" + areaSize + '\'' + ", landNumber='"
                + landNumber + '\'' + ", precinctNumber='" + precinctNumber
                + '\'' + ", districtNumber='" + districtNumber + '\''
                + ", geoMarkNumber='" + geoMarkNumber + '\'' + '}';
    }
}
