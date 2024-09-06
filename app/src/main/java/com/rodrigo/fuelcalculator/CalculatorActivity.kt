package com.rodrigo.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rodrigo.fuelcalculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

  private val binding by lazy {
    ActivityCalculatorBinding.inflate(layoutInflater)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    setupListeners()
  }

  private fun setupListeners() {
    val gasPrice = binding.editTextGasPrice.text
    val carFuelConsumption = binding.editTextCarFuelConsumption.text
    val distance = binding.editTextDistance.text


    binding.buttonCalculate.setOnClickListener {
      val result = (distance.toString().toDouble() / carFuelConsumption.toString()
        .toDouble()) * gasPrice.toString().toDouble()

      Intent(this, ResultActivity::class.java).apply {
        putExtra("distance", distance.toString().toDouble())
        putExtra("gas", gasPrice.toString().toDouble())
        putExtra("consumption", carFuelConsumption.toString().toDouble())
        putExtra("result", result)
        startActivity(this)
      }
    }
  }
}