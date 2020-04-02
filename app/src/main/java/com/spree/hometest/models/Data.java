package com.spree.hometest.models;

import com.google.gson.annotations.Expose;

import org.parceler.Parcel;

@Parcel
public class Data {

    @Expose
    String type;
    @Expose
    String id;
    @Expose
    Attributes attributes;
    @Expose
    Relationships relationships;

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
