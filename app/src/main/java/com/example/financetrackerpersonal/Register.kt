package com.example.financetrackerpersonal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//class Register : AppCompatActivity() {
//
//    private lateinit var db: DatabaseHelper
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//
//        db = DatabaseHelper(this)
//
//        val emailEditText: EditText = findViewById(R.id.editTextSignUpEmail)
//        val passwordEditText: EditText = findViewById(R.id.editTextSignUpPassword)
//        val institutionEditText: EditText = findViewById(R.id.editTextSignUpInstitution)
//        val notRobotCheckBox: CheckBox = findViewById(R.id.checkBoxNotRobot)
//        val signUpButton: Button = findViewById(R.id.buttonSignUp)
//
//        signUpButton.setOnClickListener {
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//            val institution = institutionEditText.text.toString().trim()
//
//            if (email.isEmpty() || password.isEmpty() || institution.isEmpty() || !notRobotCheckBox.isChecked) {
//                Toast.makeText(this, "Please fill all fields and check the box", Toast.LENGTH_SHORT).show()
//            } else {
//                db.addUser(email, password, institution)
//                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//    }
//}
//
//
//
////    private fun validatePassword(password: String): Boolean {
////        return if (password.length < 6) {
////            editTextPassword.error = "Password must be at least 6 characters"
////            false
////        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$".toRegex())) {
////            editTextPassword.error = "Password must be alphanumeric"
////            false
////        } else {
////            editTextPassword.error = null
////            true
////        }
////    }


class Register : AppCompatActivity() {

//    private lateinit var databaseHelper: DatabaseHelper
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//
//        databaseHelper = DatabaseHelper(this)
//
//        val buttonSignUp: Button = findViewById(R.id.buttonSignUp)
//        buttonSignUp.setOnClickListener {
//            val email = findViewById<EditText>(R.id.editTextSignUpEmail).text.toString()
//            val password = findViewById<EditText>(R.id.editTextSignUpPassword).text.toString()
//            val institution = findViewById<EditText>(R.id.editTextSignUpInstitution).text.toString()
//            databaseHelper.addUser(email, password, institution)
//            Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
//            // Redirect to login screen
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var institution: EditText
    private lateinit var registerButton: Button
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailEditText = findViewById(R.id.editTextSignUpEmail)
        passwordEditText = findViewById(R.id.editTextSignUpPassword)
        institution = findViewById(R.id.editTextSignUpInstitution)
        registerButton = findViewById(R.id.buttonSignUp)
        dbHelper = DatabaseHelper(this)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val insti = institution.text.toString()

            if (insti.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val success = dbHelper.addUser(email, password, insti)
                if (success) {
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun MainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
