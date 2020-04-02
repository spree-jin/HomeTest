package com.spree.hometest.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.spree.hometest.datasource.MainDataSourceFactory;
import com.spree.hometest.models.Data;

import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

    private MainDataSourceFactory mainDataSourceFactory;
    private LiveData<PagedList<Data>> pagedListLiveData;

    public MainViewModel(Application application){
        super(application);
        mainDataSourceFactory = new MainDataSourceFactory();

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                //.setInitialLoadSizeHint(30)
                .setPageSize(30)
                .setPrefetchDistance(10)
                .build();

        pagedListLiveData = new LivePagedListBuilder<String, Data>(mainDataSourceFactory, config)
                .setFetchExecutor(Executors.newFixedThreadPool(4))
                .build();
    }

    public LiveData<PagedList<Data>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
