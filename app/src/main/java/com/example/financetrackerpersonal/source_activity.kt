package com.example.financetrackerpersonal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.financetrackerpersonal.DatabaseHelper
import com.example.financetrackerpersonal.R
import com.example.financetrackerpersonal.investing_activity

class source_activity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var fsInput: EditText
    private lateinit var ssInput: EditText
    private lateinit var tsInput: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        dbHelper = DatabaseHelper(this)

        fsInput = findViewById(R.id.fs_input)
        ssInput = findViewById(R.id.ss_input)
        tsInput = findViewById(R.id.ts_input)
        submitButton = findViewById(R.id.Submit_button)

        submitButton.setOnClickListener {
            val firstSource = fsInput.text.toString().toDoubleOrNull() ?: 0.0
            val secondSource = ssInput.text.toString().toDoubleOrNull() ?: 0.0
            val thirdSource = tsInput.text.toString().toDoubleOrNull() ?: 0.0

            if (firstSource == 0.0 && secondSource == 0.0 && thirdSource == 0.0) {
                Toast.makeText(this, "Please enter at least one source of income", Toast.LENGTH_SHORT).show()
            } else {
                val totalIncome = firstSource + secondSource + thirdSource
                dbHelper.addIncome(firstSource, secondSource, thirdSource, totalIncome)
                Toast.makeText(this, "Income details submitted", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, investing_activity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
