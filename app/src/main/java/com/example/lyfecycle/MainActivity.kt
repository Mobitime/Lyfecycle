package com.example.lyfecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val height = findViewById< EditText>(R.id.height)
        val weight = findViewById< EditText>(R.id.weight)
        val calculate = findViewById< Button>(R.id.calculate)

        calculate.setOnClickListener{
            val heightString = height.text.toString()
            val weightString = weight.text.toString()
            if (heightString.isNotEmpty() && weightString.isNotEmpty()){
                val height = heightString.toFloat() / 100
                val weight = weightString.toFloat()

                val bmi = weight / (height * height)
                val intent = Intent(this, ResultActivity::class.java).apply{
                    putExtra("BMI_VALUE", bmi)
                }
                startActivity(intent)
            }
        }

    }
}