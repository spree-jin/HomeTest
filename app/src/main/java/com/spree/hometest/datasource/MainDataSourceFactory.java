package com.spree.hometest.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.spree.hometest.models.Meta;

public class MainDataSourceFactory extends DataSource.Factory {

    private MainDataSource mainDataSource;

    @NonNull
    @Override
    public DataSource create() {
        mainDataSource = new MainDataSource();
        return mainDataSource;
    }
}
