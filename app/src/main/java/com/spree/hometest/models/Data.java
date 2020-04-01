package com.spree.hometest.models;

import com.google.gson.annotations.Expose;

public class Data {

    @Expose
    private String type;
    @Expose
    private String id;
    @Expose
    private Attributes attributes;
    @Expose
    private Relationships relationships;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Relationships getRelationships() {
        return relationships;
    }
}
