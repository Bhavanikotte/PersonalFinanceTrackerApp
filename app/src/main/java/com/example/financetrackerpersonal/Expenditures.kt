package com.example.financetrackerpersonal

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Expenditures : AppCompatActivity() {

    private lateinit var progressBarFood: ProgressBar
    private lateinit var progressBarClothing: ProgressBar
    private lateinit var progressBarAcademics: ProgressBar
    private lateinit var progressBarHospital: ProgressBar
    private lateinit var progressBarGroceries: ProgressBar
    private lateinit var checkButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenditure)

        // Initialize the ProgressBars
        progressBarFood = findViewById(R.id.progressBar)
        progressBarClothing = findViewById(R.id.progressBar2)
        progressBarAcademics = findViewById(R.id.progressBar3)
        progressBarHospital = findViewById(R.id.progressBar4)
        progressBarGroceries = findViewById(R.id.progressBar5)
        checkButton = findViewById(R.id.check_button)

        // Set max value for ProgressBars
        setProgressBarsMax()

        // Set onClickListener for the button
        checkButton.setOnClickListener {
            updateProgressBars()
        }
    }

    private fun setProgressBarsMax() {
        progressBarFood.max = 100
        progressBarClothing.max = 100
        progressBarAcademics.max = 100
        progressBarHospital.max = 100
        progressBarGroceries.max = 100
    }

    private fun updateProgressBars() {
        progressBarFood.progress = Random.nextInt(0, 100)
        progressBarClothing.progress = Random.nextInt(0, 100)
        progressBarAcademics.progress = Random.nextInt(0, 100)
        progressBarHospital.progress = Random.nextInt(0, 100)
        progressBarGroceries.progress = Random.nextInt(0, 100)
    }
}
