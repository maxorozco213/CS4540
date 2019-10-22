package com.example.randomnumbergenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goButton: Button = findViewById(R.id.getNumberButton)
        val replacementCheckBox: CheckBox = findViewById(R.id.withReplaceCheckBox)
        val lowerBound: EditText = findViewById(R.id.lowerBoundEntry)
        val upperBound: EditText = findViewById(R.id.upperBoundEntry)
        val generatedNumView: TextView = findViewById(R.id.generatedNumber)
        val usedNumbers: ArrayList<Int> = arrayListOf()
        goButton.setOnClickListener{this.handleButtonClick(lowerBound, upperBound, generatedNumView, replacementCheckBox, usedNumbers)}
        replacementCheckBox.setOnClickListener{this.handleCheckBox(lowerBound, upperBound, generatedNumView)}
    }

    private fun handleButtonClick (lowerBound: EditText, upperBound: EditText, generatedNumView: TextView, replacementCheckBox: CheckBox, usedNumbers: ArrayList<Int>) {
        try {
            val lowerInt = lowerBound.text.toString().toInt()
            val upperInt = upperBound.text.toString().toInt()
            val valueRange: IntRange = (lowerInt..upperInt)
            var randomInt = valueRange.random()
            var isUnique = true
            val checked: Boolean = replacementCheckBox.isChecked
            print(usedNumbers)

            when (replacementCheckBox.id) {
                R.id.withReplaceCheckBox -> {
                    if (checked) {
                        while (usedNumbers.contains(randomInt)) {
                            isUnique = true
                            randomInt = valueRange.random()
                            if (usedNumbers.count() == valueRange.count()) {
                                Toast.makeText(this, "No unused numbers remaining", LENGTH_LONG).show()
                                isUnique = false
                                break
                            }
                        }

                        if(isUnique) {
                            generatedNumView.text = randomInt.toString()
                            usedNumbers.add(randomInt)
                        }
                    } else {
                        generatedNumView.text = randomInt.toString()
                    }
                }
            }
        } catch (e: Exception) {
            print("")
        }

    }

    private fun handleCheckBox(lowerBound: EditText, upperBound: EditText, generatedNumView: TextView) {
        lowerBound.text.clear()
        upperBound.text.clear()
        generatedNumView.text = ""
    }
}
