package com.example.bmizad2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.bmizad2.R;
import com.example.bmizad2.databinding.FragmentPpecalculatorBinding;

public class PPEFragment extends Fragment {
    private FragmentPpecalculatorBinding binding;
    EditText weightEditText, heightEditText, ageEditText;
    RadioGroup sexRadioGroup;
    RadioButton maleRadioButton, femaleRadioButton;
    Button calculateButton;
    TextView bmrTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PPEViewModel notificationsViewModel =
                new ViewModelProvider(this).get(PPEViewModel.class);

        binding = FragmentPpecalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        weightEditText = root.findViewById(R.id.weightEditText);
        heightEditText = root.findViewById(R.id.heightEditText);
        ageEditText = root.findViewById(R.id.ageEditText);
        sexRadioGroup = root.findViewById(R.id.sexRadioGroup);
        maleRadioButton = root.findViewById(R.id.maleRadioButton);
        femaleRadioButton = root.findViewById(R.id.femaleRadioButton);
        calculateButton = root.findViewById(R.id.calculateButton);
        bmrTextView = root.findViewById(R.id.bmrTextView);

        calculateButton.setOnClickListener(view -> {
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());
            int age = Integer.parseInt(ageEditText.getText().toString());
            int sex = 0;
            if (maleRadioButton.isChecked()) {
                sex = 1;
            } else if (femaleRadioButton.isChecked()) {
                sex = 2;
            }
            double ppm = calculatePPM(weight, height, age, sex);
            weightEditText.getText().clear();
            heightEditText.getText().clear();
            ageEditText.getText().clear();
            sexRadioGroup.clearCheck();

            bmrTextView.setText(String.format("Your PPM is %.2f", ppm));

        });

        final TextView textView = binding.textPpecalculator;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private double calculatePPM(double weight, double height, int age, int sex) {
        switch (sex) {
            case 2:
                return 655.1f + (9.563f * weight) + (1.85f * height) - (4.676f * age);
            case 1:
                return 66.5f + (13.75f * weight) + (5.003f * height) - (6.775f * age);
        }
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}