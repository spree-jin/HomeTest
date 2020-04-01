package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seo {
    @SerializedName("meta-description")
    @Expose
    private String metaDescription;
    @SerializedName("page-title")
    @Expose
    private String pageTitle;

    public String getMetaDescription() {
        return metaDescription;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
