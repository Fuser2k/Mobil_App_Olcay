package com.example.mobil_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val credentialsManager = CredentialsManager() // Doğru Tanımlama

    private val emailFile: TextInputEditText
        get() = findViewById(R.id.emailEditText)
    private val emailLayout: TextInputLayout
        get() = findViewById(R.id.emailInputLayout)
    private val passwordFile: TextInputEditText
        get() = findViewById(R.id.passwordEditText)
    private val passwordLayout: TextInputLayout
        get() = findViewById(R.id.passwordInputLayout)
    private val nextButton: Button
        get() = findViewById(R.id.nextButton)
    private val rememberCheckBox: CheckBox
        get() = findViewById(R.id.rememberMeCheckBox)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener { nextButtonClick() }
        val loginButton = findViewById<TextView>(R.id.registernow)
        loginButton.setOnClickListener {
            val goToReg = Intent(this, MainActivity2::class.java)
            startActivity(goToReg)
        }
    }

    private fun nextButtonClick() {
        val email = emailFile.text.toString().trim()
        val password = passwordFile.text.toString().trim()
        if (credentialsManager.isMistakeCredentials(email, password)) {
            navigateToMainActivity()
        } else {
            showToast("Invalid credentials!")
        }
    }

    private fun setError(layout: TextInputLayout, message: String) {
        layout.error = message
    }

    private fun clearError(layout: TextInputLayout) {
        layout.error = null
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToMainActivity() {
        clearError(emailLayout)
        clearError(passwordLayout)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
