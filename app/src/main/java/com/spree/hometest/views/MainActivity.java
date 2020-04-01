package com.spree.hometest.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spree.hometest.R;
import com.spree.hometest.adapter.MainRecyclerViewAdapter;
import com.spree.hometest.constants.Constants;
import com.spree.hometest.models.Data;
import com.spree.hometest.models.Result;
import com.spree.hometest.service.MainService;
import com.spree.hometest.viewmodels.MainViewModel;

import java.io.IOException;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.txt_find_count)
    TextView txtFindCount;

    @BindString(R.string.txt_find_count)
    String strFindCount;

    private MainRecyclerViewAdapter mainRecyclerViewAdapter;

    private MainViewModel mainViewModel;
    private Retrofit retrofit;
    private MainService mainService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainRecyclerViewAdapter = new MainRecyclerViewAdapter();

        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mainRecyclerView.setAdapter(mainRecyclerViewAdapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getMutableLiveData().observe(this, dataList -> {
            mainRecyclerViewAdapter.addDataList(dataList);
            mainRecyclerViewAdapter.notifyDataSetChanged();
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.sephora.sg")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mainService = retrofit.create(MainService.class);
        getProducts(Constants.URL_FIRST);
    }

    private void getProducts(String url){
        mainService.getProducts(url).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful() && response.body() != null){
                    mainViewModel.setResult(response.body());
                    txtFindCount.setText(response.body().getMeta().getTotalItems() + " " + strFindCount);
                } else {
                    try {
                        Log.e("error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("error", "not message");
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t){
                Log.e("onFailure", t.getMessage(), t);
            }
        });
    }
}
