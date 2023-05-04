package com.example.bmizad2.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bmizad2.R
import com.example.bmizad2.databinding.FragmentPpecalculatorBinding

class PPEFragment : Fragment() {
    private var binding: FragmentPpecalculatorBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val notificationsViewModel = ViewModelProvider(this).get(
            PPEViewModel::class.java
        )
        binding = FragmentPpecalculatorBinding.inflate(inflater, container, false)

        val root: View = binding?.root ?: return null

        val weightEditText = root.findViewById<EditText>(R.id.weightEditText)
        val heightEditText = root.findViewById<EditText>(R.id.heightEditText)
        val ageEditText = root.findViewById<EditText>(R.id.ageEditText)
        val sexRadioGroup = root.findViewById<RadioGroup>(R.id.sexRadioGroup)
        val maleRadioButton = root.findViewById<RadioButton>(R.id.maleRadioButton)
        val femaleRadioButton = root.findViewById<RadioButton>(R.id.femaleRadioButton)
        val calculateButton = root.findViewById<Button>(R.id.calculateButton)
        val bmrTextView = root.findViewById<TextView>(R.id.bmrTextView)

        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString().toDoubleOrNull() ?: 0.0
            val height = heightEditText.text.toString().toDoubleOrNull() ?: 0.0
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            var sex = 0
            if (maleRadioButton.isChecked) {
                sex = 1
            } else if (femaleRadioButton.isChecked) {
                sex = 2
            }
            val ppm = calculatePPM(weight, height, age, sex)
            weightEditText.text.clear()
            heightEditText.text.clear()
            ageEditText.text.clear()
            sexRadioGroup.clearCheck()
            bmrTextView.text = String.format("Your PPM is %.2f", ppm)
        }

        notificationsViewModel.text.observe(viewLifecycleOwner) { text ->
            binding?.textPpecalculator?.text = text
        }

        return root
    }

    private fun calculatePPM(weight: Double, height: Double, age: Int, sex: Int): Double {
        return when (sex) {
            2 -> 655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
            1 -> 66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
            else -> 0.0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

