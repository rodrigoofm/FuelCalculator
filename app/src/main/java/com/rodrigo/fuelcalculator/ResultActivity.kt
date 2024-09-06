package com.rodrigo.fuelcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigo.fuelcalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

  private val binding by lazy {
    ActivityResultBinding.inflate(layoutInflater)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    val result = intent.getDoubleExtra("result", 0.0)
    val gas = intent.getDoubleExtra("gas", 0.0)
    val consumption = intent.getDoubleExtra("consumption", 0.0)
    val distance = intent.getDoubleExtra("distance", 0.0)

    binding.textResult.text = result.toString()
    binding.textPrice.text = gas.toString()
    binding.textConsumption.text = consumption.toString()
    binding.textDistance.text = distance.toString()

  }
}