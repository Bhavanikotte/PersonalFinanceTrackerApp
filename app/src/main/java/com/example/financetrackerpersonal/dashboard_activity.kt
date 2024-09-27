package com.example.financetrackerpersonal

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.financetrackerpersonal.investing_activity
import com.example.financetrackerpersonal.source_activity
import com.example.financetrackerpersonal.R

class dashboard_activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get references to the CardViews
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)
        val card4 = findViewById<CardView>(R.id.card4)
        val card5 = findViewById<CardView>(R.id.card5)


        card1.setOnClickListener {
            Toast.makeText(this, "User details: where your digital self comes to life", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, userdetails_activity::class.java)
            startActivity(intent)
        }

        card2.setOnClickListener {
            Toast.makeText(this, "It's the little expenses that add up!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, investing_activity::class.java)
            startActivity(intent)
        }

        card3.setOnClickListener {
            Toast.makeText(this, "Income streams: where dreams meet reality.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, source_activity::class.java)
            startActivity(intent)
        }

        card4.setOnClickListener {
            Toast.makeText(this, "Bank balance: The silent narrator of your financial tale.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, thankyou_activity::class.java)
            startActivity(intent)
        }

        card5.setOnClickListener {
            Toast.makeText(this, "Analytics", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Expenditures::class.java)
            startActivity(intent)
        }

        val budgetingTextView: TextView = findViewById(R.id.budgetingTextView)
        budgetingTextView.setOnClickListener {
            val url = "https://economictimes.indiatimes.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}