package com.example.bmizad2.ui.bmiCalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BMICalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BMICalculatorViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("Enter weight and height to count BMI");

    }

    public LiveData<String> getText() {
        return mText;
    }
}