package com.spree.hometest.instance;

import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;

import com.spree.hometest.models.Meta;

public class MetaMutableLiveData extends MutableLiveData<Meta> {
    private static MetaMutableLiveData instance;

    @MainThread
    public static MetaMutableLiveData getInstance() {
        if(instance == null){
            instance = new MetaMutableLiveData();
        }
        return instance;
    }
}
