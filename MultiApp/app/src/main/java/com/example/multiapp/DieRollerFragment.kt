package com.example.multiapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.multiapp.databinding.FragmentDierollerBinding

class DieRollerFragment: Fragment() {
    lateinit var drawableImage: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDierollerBinding>(
            inflater, R.layout.fragment_dieroller, container, false)
        binding.dieRoller = this

        drawableImage = binding.diceImage
        binding.rollButton.setOnClickListener @Suppress ("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            Log.i("ROLLED", "Button was pressed")
            val randomInt = java.util.Random().nextInt(6) + 1
            val drawableDice = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

                drawableImage.setImageResource(drawableDice)
        }

        binding.navToTipCalc.setOnClickListener @Suppress ("UNUSED_ANONYMOUS_PARAMETER")
        { navView: View ->
                navView.findNavController()
                    .navigate(R.id.action_dieRollerFragment_to_tipCalculatorFragment)
        }

        return binding.root
    }
}