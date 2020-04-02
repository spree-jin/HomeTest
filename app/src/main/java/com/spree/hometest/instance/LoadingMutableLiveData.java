package com.spree.hometest.instance;

import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;

public class LoadingMutableLiveData extends MutableLiveData<Boolean> {
    private static LoadingMutableLiveData instance;

    @MainThread
    public static LoadingMutableLiveData getInstance() {
        if(instance == null){
            instance = new LoadingMutableLiveData();
        }
        return instance;
    }
}
