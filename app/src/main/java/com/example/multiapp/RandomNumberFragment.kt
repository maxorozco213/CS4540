package com.example.multiapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.multiapp.databinding.FragmentRandnumBinding

class RandomNumberFragment: Fragment() {
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentRandnumBinding>(
            inflater, R.layout.fragment_randnum, container, false)

        binding.randNumGen = this

        binding.getNumberButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            try {
                val lowerInt: Int = binding.upperBoundEntry.text.toString().toInt()
                val upperInt: Int = binding.upperBoundEntry.text.toString().toInt()
                val valueRange: IntRange = (lowerInt..upperInt)
                val usedNumbers: ArrayList<Int> = arrayListOf()
                val checked: Boolean = binding.withReplaceCheckBox.isChecked
                val randNumView = binding.generatedNumber
                var randomInt = valueRange.random()
                var isUnique = true
                print(usedNumbers)

                when (checked) {
                    checked -> {
                        if (checked) {
                            while (usedNumbers.contains(randomInt)) {
                                isUnique = true
                                randomInt = valueRange.random()
                                if (usedNumbers.count() == valueRange.count()) {
                                    Toast.makeText(context, "No unused numbers remaining",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    isUnique = false
                                    break
                                }
                            }

                            if(isUnique) {
                                randNumView.text = randomInt.toString()
                                usedNumbers.add(randomInt)
                            }
                        } else {
                            randNumView.text = randomInt.toString()
                        }
                    }
                }
            } catch (e: Exception) {
                print("")
            }

        }
        return binding.root
    }
}