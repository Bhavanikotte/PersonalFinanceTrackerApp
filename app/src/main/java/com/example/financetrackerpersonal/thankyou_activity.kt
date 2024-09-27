package com.example.financetrackerpersonal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class thankyou_activity : AppCompatActivity() {

    private lateinit var dailyBalanceTextView: TextView
    private lateinit var monthlyBalanceTextView: TextView
    private lateinit var annualBalanceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        dailyBalanceTextView = findViewById(R.id.daily_input)
        monthlyBalanceTextView = findViewById(R.id.monthly_input)
        annualBalanceTextView = findViewById(R.id.annual_input)

        val dailyBalance = intent.getDoubleExtra("daily_balance", 0.0)
        val monthlyBalance = intent.getDoubleExtra("monthly_balance", 0.0)
        val annualBalance = intent.getDoubleExtra("annual_balance", 0.0)

        dailyBalanceTextView.text = "$dailyBalance"
        monthlyBalanceTextView.text = "$monthlyBalance"
        annualBalanceTextView.text = "$annualBalance"
    }
}
