package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText massEdit;
    private EditText heightEdit;
    private TextView bmiTextView;

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        massEdit = (EditText) findViewById(R.id.massEditText);
        heightEdit = (EditText) findViewById(R.id.heightEditText);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();
            }
        });
    }
    private void calculate() {
        float mass = Float.parseFloat(massEdit.getText().toString());
        float height = Float.parseFloat(heightEdit.getText().toString()) / 100;
        float bmi = mass/(height*height);
        String calculatedBmi = String.format("%.2f", bmi);
        bmiTextView.setText(calculatedBmi);
    }

}