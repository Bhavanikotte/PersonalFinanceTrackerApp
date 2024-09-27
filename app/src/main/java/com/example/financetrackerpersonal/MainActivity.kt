package com.example.financetrackerpersonal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//class MainActivity : AppCompatActivity() {
//
//    private lateinit var db: DatabaseHelper
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        db = DatabaseHelper(this)
//
//        val emailEditText: EditText = findViewById(R.id.editTextLoginEmail)
//        val passwordEditText: EditText = findViewById(R.id.editTextLoginPassword)
//        val signInButton: Button = findViewById(R.id.buttonSignIn)
//        val textViewSignUpPrompt: TextView = findViewById(R.id.textViewSignUpPrompt)
//
//        textViewSignUpPrompt.setOnClickListener {
//            val intent = Intent(this, Register::class.java)
//            startActivity(intent)
//        }
//        signInButton.setOnClickListener {
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (db.checkUser(email, password)) {
//                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, dashboard_activity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}


class MainActivity : AppCompatActivity() {
    private lateinit var emailOrNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpPromptTextView: TextView
    private lateinit var signInButton: Button

    private lateinit var dbHelper: DatabaseHelper

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        emailOrNameEditText = findViewById(R.id.editTextLoginEmail)
//        passwordEditText = findViewById(R.id.editTextLoginPassword)
//        signUpPromptTextView = findViewById(R.id.textViewSignUpPrompt)
//        signInButton=findViewById(R.id.buttonSignIn)
//        dbHelper = DatabaseHelper(this)
//        val buttonSignIn: Button = findViewById(R.id.buttonSignIn)
//        signUpPromptTextView.setOnClickListener {
//            val intent = Intent(this, Register::class.java)
//            startActivity(intent)
//        }
//
//        signInButton.setOnClickListener {
//            val emailOrName = emailOrNameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            if (dbHelper.checkUser(emailOrName, password)) {
//                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, dashboard_activity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
//            }
//        }
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    emailOrNameEditText = findViewById(R.id.editTextLoginEmail)
    passwordEditText = findViewById(R.id.editTextLoginPassword)
    signUpPromptTextView = findViewById(R.id.textViewSignUpPrompt)
    signInButton = findViewById(R.id.buttonSignIn)
    dbHelper = DatabaseHelper(this)

    signUpPromptTextView.setOnClickListener {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    signInButton.setOnClickListener {
        val emailOrName = emailOrNameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (dbHelper.checkUser(emailOrName, password)) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, dashboard_activity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid email, name or password", Toast.LENGTH_SHORT).show()
        }
    }
    fun Register(view: View) {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)

    }
    fun Dashboard(view: View) {
        val intent = Intent(this, dashboard_activity::class.java)
        startActivity(intent)

    }

}
}
