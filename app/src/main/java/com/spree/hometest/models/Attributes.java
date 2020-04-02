package com.spree.hometest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Attributes {

    @Expose
    String name;
    @Expose
    String heading;
    @Expose
    float rating;
    @SerializedName("how-to-text")
    @Expose
    String howToText;
    @Expose
    String description;
    @Expose
    String benefits;
    @Expose
    String application;
    @Expose
    String ingredients;
    @Expose
    Seo seo;
    @SerializedName("available-on-modiface")
    @Expose
    boolean avaliableOnModiface;
    @SerializedName("available-on-findation")
    @Expose
    boolean avaliableOnFindation;
    @SerializedName("findation-id")
    @Expose
    String findationId;
    @SerializedName("slug-url")
    @Expose
    String slugUrl;
    @SerializedName("variants-count")
    @Expose
    int variantsCount;
    @Expose
    List<String> labels;
    @SerializedName("web-url")
    @Expose
    String webUrl;
    @SerializedName("featured-variant-id")
    @Expose
    long featuredVariantId;
    @SerializedName("reviews-count")
    @Expose
    int reviewsCount;
    @SerializedName("new-arrival")
    @Expose
    boolean newArrival;
    @SerializedName("how-to")
    @Expose
    String howTo;
    @SerializedName("option-type-categories")
    @Expose
    List<String> optionTypeCategories;
    @SerializedName("image-urls")
    @Expose
    List<String> imageUrls;
    @SerializedName("icon-image-urls")
    @Expose
    List<String> iconImageUrls;
    @SerializedName("cart-image-urls")
    @Expose
    List<String> cartImageUrls;
    @SerializedName("default-image-urls")
    @Expose
    List<String> defaultImageUrls;
    @SerializedName("closeup-image-urls")
    @Expose
    List<String> closeupImageUrls;
    @SerializedName("zoom-image-urls")
    @Expose
    List<String> zoomImageUrls;
    @Expose
    String price;
    @SerializedName("original-price")
    @Expose
    String originalPrice;
    @SerializedName("under-sale")
    @Expose
    boolean underSale;
    @SerializedName("sale-text")
    @Expose
    String saleText;
    @SerializedName("sold-out")
    @Expose
    boolean soldOut;

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
