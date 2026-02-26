package com.example.loginvalidation

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalcafeloginvalidation.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val button = findViewById<Button>(R.id.validateButton)

        button.setOnClickListener {

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            // 1. Check empty fields
            if (email.isEmpty() || password.isEmpty()) {
                resultText.text = "Fields should not be empty"
                return@setOnClickListener
            }

            // 2. Check college email (example: must end with .edu)
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.endsWith(".edu")) {
                resultText.text = "Enter valid college email id"
                return@setOnClickListener
            }

            // 3. Password validation
            val passwordPattern =
                Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")

            if (!password.matches(passwordPattern)) {
                resultText.text = "Password must have 12 characters, 1 uppercase, 1 number, 1 special symbol"
                return@setOnClickListener
            }

            resultText.text = "Login Validated Successfully"
        }
    }
}
