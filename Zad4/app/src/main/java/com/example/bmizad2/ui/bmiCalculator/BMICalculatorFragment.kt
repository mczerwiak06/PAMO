package com.example.bmizad2.ui.bmiCalculator

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bmizad2.R
import com.example.bmizad2.databinding.FragmentBmicalculatorBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class BMICalculatorFragment : Fragment() {

    private var binding: FragmentBmicalculatorBinding? = null
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var bmiTextView: TextView
    private lateinit var mpLineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bMICalculatorViewModel =
            ViewModelProvider(this).get(BMICalculatorViewModel::class.java)

        binding = FragmentBmicalculatorBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        weightEditText = root.findViewById(R.id.weightEditText)
        heightEditText = root.findViewById(R.id.heightEditText)
        calculateButton = root.findViewById(R.id.calculateButton)
        bmiTextView = root.findViewById(R.id.bmiTextView)
        mpLineChart = root.findViewById(R.id.lineChart)
        val lineDataSetBmi = LineDataSet(bmiValues(), "BMI values")
        val dataSets: ArrayList<ILineDataSet> = ArrayList()
        lineDataSetBmi.color = Color.RED
        dataSets.add(lineDataSetBmi)

        // Styling
/*        mpLineChart.drawGridBackground = true
        mpLineChart.drawBorders(true)
        mpLineChart.borderColor = Color.GRAY
        mpLineChart.borderWidth = 2f*/

        val description = Description()
        description.text = "BMI"
        description.setTextColor(Color.BLUE)
        description.textSize = 20f
        mpLineChart.description = description

        val data = LineData(dataSets)
        mpLineChart.data = data
        mpLineChart.invalidate()

        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString().toDouble()
            val height = heightEditText.text.toString().toDouble() / 100
            val bmi = calculateBMI(weight, height)
            bmiTextView.text = String.format("Your BMI is %.2f", bmi)
        }

        val textView = binding!!.textBmiCalculator
        bMICalculatorViewModel.text.observe(viewLifecycleOwner) { textView.text = it }
        return root
    }

    private fun bmiValues(): ArrayList<Entry> {
        val dataVals = ArrayList<Entry>()
        dataVals.add(Entry(0f, 71f))
        dataVals.add(Entry(1f, 74f))
        dataVals.add(Entry(2f, 76f))
        dataVals.add(Entry(3f, 70f))
        dataVals.add(Entry(4f, 75f))
        dataVals.add(Entry(5f, 72f))
        return dataVals
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
