package com.example.financetrackerpersonal

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class userdetails_activity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private val databaseHelper by lazy { DatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_userdetails)
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
             val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
             insets
         }*/
    }

    fun buttonSubmit(view: View) {
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val phone = editTextPhone.text.toString()

        val db = databaseHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("email", email)
            put("phone", phone)
        }
        db.insert("users", null, values)
        db.close()
        Toast.makeText(this, "User details submitted!", Toast.LENGTH_SHORT).show()
        // Navigate to the next activity or perform other actions after submission
    }

    fun back(view: View) {
        val intent = Intent(this, dashboard_activity::class.java)
        startActivity(intent)
    }
}