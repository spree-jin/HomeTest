package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {
    @Expose
    private int total;
    @SerializedName("total-pages")
    @Expose
    private int totalPages;
    @SerializedName("total-items")
    @Expose
    private int totalItems;
    @SerializedName("current-page")
    @Expose
    private int currentPage;
    @SerializedName("per-page")
    @Expose
    private int perPage;

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPerPage() {
        return perPage;
    }
}
