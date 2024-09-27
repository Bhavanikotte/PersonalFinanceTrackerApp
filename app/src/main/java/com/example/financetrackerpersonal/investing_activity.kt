package com.example.financetrackerpersonal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.financetrackerpersonal.DatabaseHelper
import com.example.financetrackerpersonal.R
import com.example.financetrackerpersonal.thankyou_activity

class investing_activity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var foodInput: EditText
    private lateinit var clothingInput: EditText
    private lateinit var academyInput: EditText
    private lateinit var hospitalInput: EditText
    private lateinit var groceriesInput: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investing)

        dbHelper = DatabaseHelper(this)

        foodInput = findViewById(R.id.food_input)
        clothingInput = findViewById(R.id.clothing_input)
        academyInput = findViewById(R.id.academy_input)
        hospitalInput = findViewById(R.id.hospital_input)
        groceriesInput = findViewById(R.id.groceries_input)
        checkButton = findViewById(R.id.check_button)

        checkButton.setOnClickListener {
            val food = foodInput.text.toString().toDoubleOrNull() ?: 0.0
            val clothing = clothingInput.text.toString().toDoubleOrNull() ?: 0.0
            val academy = academyInput.text.toString().toDoubleOrNull() ?: 0.0
            val hospital = hospitalInput.text.toString().toDoubleOrNull() ?: 0.0
            val groceries = groceriesInput.text.toString().toDoubleOrNull() ?: 0.0

            val totalExpenditure = food + clothing + academy + hospital + groceries
            val totalIncome = dbHelper.getTotalIncome()
            val remainingBalance = totalIncome - totalExpenditure

            // Calculate daily, monthly, and annual expenditures
            val dailyExpenditure = totalExpenditure / 30
            val monthlyExpenditure = totalExpenditure
            val annualExpenditure = totalExpenditure * 12

            // Store these balances in the database
            dbHelper.addExpenditure(food, clothing, academy, hospital, groceries, totalExpenditure)
            dbHelper.addDailyExpenditure(dailyExpenditure)
            dbHelper.addMonthlyExpenditure(monthlyExpenditure)
            dbHelper.addAnnualExpenditure(annualExpenditure)

            Toast.makeText(this, "Remaining balance: $remainingBalance", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, thankyou_activity::class.java)
            intent.putExtra("daily_balance", dailyExpenditure)
            intent.putExtra("monthly_balance", monthlyExpenditure)
            intent.putExtra("annual_balance", annualExpenditure)
            startActivity(intent)
        }
    }
}
