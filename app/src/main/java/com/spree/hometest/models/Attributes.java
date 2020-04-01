package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attributes {

    @Expose
    private String name;
    @Expose
    private String heading;
    @Expose
    private float rating;
    @SerializedName("how-to-text")
    @Expose
    private String howToText;
    @Expose
    private String description;
    @Expose
    private String benefits;
    @Expose
    private String application;
    @Expose
    private String ingredients;
    @Expose
    private Seo seo;
    @SerializedName("available-on-modiface")
    @Expose
    private boolean avaliableOnModiface;
    @SerializedName("available-on-findation")
    @Expose
    private boolean avaliableOnFindation;
    @SerializedName("findation-id")
    @Expose
    private String findationId;
    @SerializedName("slug-url")
    @Expose
    private String slugUrl;
    @SerializedName("variants-count")
    @Expose
    private int variantsCount;
    @Expose
    private List<String> labels;
    @SerializedName("web-url")
    @Expose
    private String webUrl;
    @SerializedName("featured-variant-id")
    @Expose
    private long featuredVariantId;
    @SerializedName("reviews-count")
    @Expose
    private int reviewsCount;
    @SerializedName("new-arrival")
    @Expose
    private boolean newArrival;
    @SerializedName("how-to")
    @Expose
    private String howTo;
    @SerializedName("option-type-categories")
    @Expose
    private List<String> optionTypeCategories;
    @SerializedName("image-urls")
    @Expose
    private List<String> imageUrls;
    @SerializedName("icon-image-urls")
    @Expose
    private List<String> iconImageUrls;
    @SerializedName("cart-image-urls")
    @Expose
    private List<String> cartImageUrls;
    @SerializedName("default-image-urls")
    @Expose
    private List<String> defaultImageUrls;
    @SerializedName("closeup-image-urls")
    @Expose
    private List<String> closeupImageUrls;
    @SerializedName("zoom-image-urls")
    @Expose
    private List<String> zoomImageUrls;
    @Expose
    private String price;
    @SerializedName("original-price")
    @Expose
    private String originalPrice;
    @SerializedName("under-sale")
    @Expose
    private boolean underSale;
    @SerializedName("sale-text")
    @Expose
    private String saleText;
    @SerializedName("sold-out")
    @Expose
    private boolean soldOut;

    public String getName() {
        return name;
    }

    public String getHeading() {
        return heading;
    }

    public float getRating() {
        return rating;
    }

    public String getHowToText() {
        return howToText;
    }

    public String getDescription() {
        return description;
    }

    public String getBenefits() {
        return benefits;
    }

    public String getApplication() {
        return application;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Seo getSeo() {
        return seo;
    }

    public boolean isAvaliableOnModiface() {
        return avaliableOnModiface;
    }

    public boolean isAvaliableOnFindation() {
        return avaliableOnFindation;
    }

    public String getFindationId() {
        return findationId;
    }

    public String getSlugUrl() {
        return slugUrl;
    }

    public int getVariantsCount() {
        return variantsCount;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public long getFeaturedVariantId() {
        return featuredVariantId;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public boolean isNewArrival() {
        return newArrival;
    }

    public String getHowTo() {
        return howTo;
    }

    public List<String> getOptionTypeCategories() {
        return optionTypeCategories;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public List<String> getIconImageUrls() {
        return iconImageUrls;
    }

    public List<String> getCartImageUrls() {
        return cartImageUrls;
    }

    public List<String> getDefaultImageUrls() {
        return defaultImageUrls;
    }

    public List<String> getCloseupImageUrls() {
        return closeupImageUrls;
    }

    public List<String> getZoomImageUrls() {
        return zoomImageUrls;
    }

    public String getPrice() {
        return price;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public boolean isUnderSale() {
        return underSale;
    }

    public String getSaleText() {
        return saleText;
    }

    public boolean isSoldOut() {
        return soldOut;
    }
}
