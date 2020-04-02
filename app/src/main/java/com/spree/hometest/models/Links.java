package com.spree.hometest.models;

import com.google.gson.annotations.Expose;

public class Links {
    @Expose
    private String self;
    @Expose
    private String next;
    @Expose
    private String last;

    public String getSelf() {
        return self;
    }

    public String getNext() {
        return next;
    }

    public String getLast() {
        return last;
    }
}
