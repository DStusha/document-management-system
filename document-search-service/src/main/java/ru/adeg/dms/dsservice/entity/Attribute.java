package ru.adeg.dms.dsservice.entity;

public class Attribute {
    private String attribute_name;
    private String attribyte_value;

    public Attribute(){}

    public Attribute(String attribyteName, String attribyteValue) {
        this.attribute_name = attribyteName;
        this.attribyte_value = attribyteValue;
    }

    public String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }

    public String getAttribyte_value() {
        return attribyte_value;
    }

    public void setAttribyte_value(String attribyte_value) {
        this.attribyte_value = attribyte_value;
    }
}
