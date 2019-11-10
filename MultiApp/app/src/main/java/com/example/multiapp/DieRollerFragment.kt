package com.example.multiapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.multiapp.databinding.FragmentDierollerBinding
import kotlin.random.Random

class DieRollerFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDierollerBinding>(
            inflater, R.layout.fragment_dieroller, container, false)
        binding.dieRoller = this

        lateinit var drawableImage: ImageView

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

        return binding.root
    }
}