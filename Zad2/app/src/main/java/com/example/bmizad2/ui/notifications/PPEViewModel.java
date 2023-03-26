package com.example.bmizad2.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PPEViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PPEViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Count your basic metabolism:");
    }

    public LiveData<String> getText() {
        return mText;
    }
}