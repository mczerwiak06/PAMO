package com.example.bmizad2.ui.bmiCalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.bmizad2.R;
import com.example.bmizad2.databinding.FragmentBmicalculatorBinding;

public class BMICalculatorFragment extends Fragment {

    private FragmentBmicalculatorBinding binding;

    EditText weightEditText, heightEditText;
    Button calculateButton;
    TextView bmiTextView;

    @SuppressLint("DefaultLocale")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BMICalculatorViewModel BMICalculatorViewModel =
                new ViewModelProvider(this).get(BMICalculatorViewModel.class);

        binding = FragmentBmicalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        weightEditText = root.findViewById(R.id.weightEditText);
        heightEditText = root.findViewById(R.id.heightEditText);
        calculateButton = root.findViewById(R.id.calculateButton);
        bmiTextView = root.findViewById(R.id.bmiTextView);

        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString()) / 100;
            double bmi = calculateBMI(weight, height);
            bmiTextView.setText(String.format("Your BMI is %.2f", bmi));
        });

        final TextView textView = binding.textBmiCalculator;
        BMICalculatorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private double calculateBMI(double weight, double height) {
        return weight/height*height;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}