package com.grace.superhero.model;

public class SupsDetailModel {

    private String Header;
    private String BodyItems;

    public SupsDetailModel(String header, String bodyItems) {
        Header = header;
        BodyItems = bodyItems;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getBodyItems() {
        return BodyItems;
    }

    public void setBodyItems(String bodyItems) {
        BodyItems = bodyItems;
    }
}
