package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Relationships {
    @Expose
    private Map<String, String> brand;
    @SerializedName("featured-variant")
    @Expose
    private Map<String, String> featuredVariant;
    @SerializedName("featured-ad")
    @Expose
    private Map<String, String> featuredAd;
    @SerializedName("featured-review")
    @Expose
    private Map<String, String> featuredReview;
    @Expose
    private Map<String, String> categories;
    @SerializedName("option-types")
    @Expose
    private Map<String, String> optionTypes;
    @Expose
    private Map<String, String> variants;

    public Map<String, String> getBrand() {
        return brand;
    }

    public Map<String, String> getFeaturedVariant() {
        return featuredVariant;
    }

    public Map<String, String> getFeaturedAd() {
        return featuredAd;
    }

    public Map<String, String> getFeaturedReview() {
        return featuredReview;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public Map<String, String> getOptionTypes() {
        return optionTypes;
    }

    public Map<String, String> getVariants() {
        return variants;
    }
}
