package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.multiapp.databinding.FragmentTipCalculatorBinding
import java.lang.Exception

class TipCalculatorFragment: Fragment() {
    private var tipAmount: Double = 1.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentTipCalculatorBinding>(
            inflater, R.layout.fragment_tip_calculator, container, false)
        binding.tipCalculator = this

        val billAmountEntered: EditText = binding.checkBeforeTip
        val checkWithTip: TextView = binding.totalWithTip
        lateinit var finalTotal: String

        binding.radioGroup.setOnCheckedChangeListener @Suppress ("UNUSED_ANONYMOUS_PARAMETER")
        { group, ID ->
            Log.i("PRESSED", "Tip Calculated")
            when (ID) {
                R.id.tipFifteen -> {
                    tipAmount = .15
                }
                R.id.tipEighteen -> {
                    tipAmount = .18
                }
                R.id.tipTwenty -> {
                    tipAmount = .20
                }
                else -> {
                    Toast.makeText(context, "Select an amount to tip", Toast.LENGTH_SHORT)
                    Log.i("RADIO BUTTON", "Nothing selected")
                }
            }
        }

        binding.calculateButton.setOnClickListener @Suppress ("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            try {
                val billDouble: Double = billAmountEntered.text.toString().toDouble()
                finalTotal = (billDouble * tipAmount).toString()

                checkWithTip.text = finalTotal
            } catch (e: Exception){
                print("")
            }

            binding.sendToEmail.setOnClickListener @Suppress ("UNUSED_ANONYMOUS_PARAMETER")
            { emailView: View ->
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, finalTotal)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

        return binding.root
    }
}