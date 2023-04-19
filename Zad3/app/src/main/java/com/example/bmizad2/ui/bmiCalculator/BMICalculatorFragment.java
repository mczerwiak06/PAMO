package com.example.bmizad2.ui.bmiCalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class BMICalculatorFragment extends Fragment {

    private FragmentBmicalculatorBinding binding;

    EditText weightEditText, heightEditText;
    Button calculateButton;
    TextView bmiTextView;
    LineChart mpLineChart;

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
        mpLineChart = root.findViewById(R.id.lineChart);
        LineDataSet lineDataSetBmi = new LineDataSet(bmiValues(), "BMI values");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        lineDataSetBmi.setColor(Color.RED);
        dataSets.add(lineDataSetBmi);

        //Styling
        mpLineChart.setDrawGridBackground(true);
        mpLineChart.setDrawBorders(true);
        mpLineChart.setBorderColor(Color.GRAY);
        mpLineChart.setBorderWidth(2);


        Description description = new Description();
        description.setText("BMI");
        description.setTextColor(Color.BLUE);
        description.setTextSize(20);
        mpLineChart.setDescription(description);


        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

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

    private ArrayList<Entry> bmiValues(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 71));
        dataVals.add(new Entry(1, 74));
        dataVals.add(new Entry(2, 76));
        dataVals.add(new Entry(3, 70));
        dataVals.add(new Entry(4, 75));
        dataVals.add(new Entry(5, 72));

        return dataVals;
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