package com.spree.hometest.service;

import com.spree.hometest.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MainService {
    @GET
    Call<Result> getProducts(@Url String url);
}
