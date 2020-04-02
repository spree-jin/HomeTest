package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Seo {
    @SerializedName("meta-description")
    @Expose
    String metaDescription;
    @SerializedName("page-title")
    @Expose
    String pageTitle;

    public String getMetaDescription() {
        return metaDescription;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
