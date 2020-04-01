package com.spree.hometest.service;

import com.spree.hometest.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MainService {
    // https://api.sephora.sg/api/v2.5/products?filter%5Bplatform%5D=mobile_app&filter%5Bproduct_group%5D=bestsellers&page%5Bsize%5D=30 //&include=bran
    @GET
    Call<Result> getProducts(@Url String url);
}
