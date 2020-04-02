package com.spree.hometest.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.spree.hometest.constants.Constants;
import com.spree.hometest.instance.MetaMutableLiveData;
import com.spree.hometest.instance.LoadingMutableLiveData;
import com.spree.hometest.instance.RetrofitClientInstance;
import com.spree.hometest.models.Data;
import com.spree.hometest.models.Links;
import com.spree.hometest.models.Result;
import com.spree.hometest.service.MainService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainDataSource extends PageKeyedDataSource<String, Data> {

    private MainService mainService;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull LoadInitialCallback<String, Data> callback) {
        mainService = RetrofitClientInstance.getRetrofitInstance().create(MainService.class);
        mainService.getProducts(Constants.URL_FIRST).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                LoadingMutableLiveData.getInstance().setValue(false);
                if(response.isSuccessful()){
                    List<Data> dataList = response.body().getData();
                    Links links = response.body().getLinks();
                    MetaMutableLiveData.getInstance().setValue(response.body().getMeta());
                    callback.onResult(dataList, null, links.getNext());
                } else {
                    Log.e("fail", String.valueOf(response.errorBody()));
                    callback.onError(new Throwable(String.valueOf(response.errorBody())));
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                LoadingMutableLiveData.getInstance().setValue(false);
                callback.onError(t);
                Log.e("fail", t.getMessage(), t);
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Data> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Data> callback) {
        mainService = RetrofitClientInstance.getRetrofitInstance().create(MainService.class);
        mainService.getProducts(params.key).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    List<Data> dataList = response.body().getData();
                    Links links = response.body().getLinks();
                    MetaMutableLiveData.getInstance().setValue(response.body().getMeta());
                    callback.onResult(dataList, links.getNext());
                } else {
                    Log.e("fail", String.valueOf(response.errorBody()));
                    callback.onError(new Throwable(String.valueOf(response.errorBody())));
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                callback.onError(t);
                Log.e("fail", t.getMessage(), t);
            }
        });
    }
}
