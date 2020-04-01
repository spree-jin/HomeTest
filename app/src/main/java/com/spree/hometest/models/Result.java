package com.spree.hometest.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Result {

    @Expose
    private List<Data> data;
    @Expose
    private Meta meta;
    @Expose
    private Links links;

    public List<Data> getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    public Links getLinks() {
        return links;
    }
}
