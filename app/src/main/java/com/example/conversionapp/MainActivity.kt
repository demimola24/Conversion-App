package com.example.conversionapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversionapp.adapter.MySpinnerAdapter
import com.example.conversionapp.data.MeasurementType
import com.example.conversionapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedMeasurementType : MeasurementType? = null
    private var numberInput: Long = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      // all values of out created enum set
        val data = MeasurementType.values()

        binding.spUnits.adapter = MySpinnerAdapter(this, data)

        //listen for chances in the unit selection
        binding.spUnits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedMeasurementType = data[position]
                binding.tvConversionSelectedHint.text= "Hint: 1 ${selectedMeasurementType?.name} is  " +
                        "${selectedMeasurementType?.conversionConstant} ${selectedMeasurementType?.conversionUnit?.uppercase()}"
                calculatedValue()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //listen for chances in the user's input
        binding.tlConversionValue.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                numberInput =  s.toString().toLongOrNull()?:0
                calculatedValue()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun calculatedValue(){
        //Calculate conversion

        selectedMeasurementType?.let {
            val numericValue = numberInput * (it.conversionConstant)
            binding.tvResultValue.text = "$numericValue ${it.conversionUnit}"
        }
    }
}