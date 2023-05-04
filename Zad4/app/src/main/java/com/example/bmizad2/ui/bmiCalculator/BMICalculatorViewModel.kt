package com.example.bmizad2.ui.bmiCalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BMICalculatorViewModel : ViewModel() {
    private val mText: MutableLiveData<String> = MutableLiveData()

    init {
        mText.value = "Enter weight and height to count BMI"
    }

    val text: LiveData<String>
        get() = mText
}