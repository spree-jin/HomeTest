package com.spree.hometest.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.spree.hometest.models.Data;
import com.spree.hometest.models.Links;
import com.spree.hometest.models.Result;

import java.util.List;

public class MainViewModel extends ViewModel {
    private Links links;

    private final MutableLiveData<List<Data>> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<Data>> getMutableLiveData(){
        return mutableLiveData;
    }

    public MainViewModel(){
        // trigger main model load.
    }

    public void setResult(Result result) {
        mutableLiveData.setValue(result.getData());
        links = result.getLinks();
    }

    void doAction(){
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}
