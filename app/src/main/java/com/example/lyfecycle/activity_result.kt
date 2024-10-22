package com.example.lyfecycle

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val bmiResult = findViewById<TextView>(R.id.bmi_result)
        val bodyImage = findViewById<ImageView>(R.id.body)
        val recommend = findViewById<TextView>(R.id.recommend)

        val  bmi = intent.getFloatExtra("BMI_VALUE", 0f)




        bmiResult.text = String.format("Ваш ИМТ: %.2f", bmi)

        val (imageResId, recommendations) = when{
            bmi < 18.5 -> Pair(R.drawable.to1, "Нужно набрать массу")
            bmi in 18.5..24.9 -> Pair(R.drawable.strong1, "Продолжай в том же духе")
            bmi in 25.0..29.9 -> Pair(R.drawable.fat1, "Пора встать с дивана ")
            else -> Pair(R.drawable.zal1,"Ты сможешь ")
        }
        bodyImage.setImageResource(imageResId)
        recommend.text = recommendations
    }
}