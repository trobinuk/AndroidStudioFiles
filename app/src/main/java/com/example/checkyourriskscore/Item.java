package com.example.checkyourriskscore;

public class Item
{
    String attribute;
    String attributeVal;

    public Item(String attribute, String attributeVal) {
        this.attribute = attribute;
        this.attributeVal = attributeVal;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getAttributeVal() {
        return attributeVal;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setAttributeVal(String attributeVal) {
        this.attributeVal = attributeVal;
    }
}