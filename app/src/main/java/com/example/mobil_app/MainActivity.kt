package com.example.mobil_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

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
    private val toggleFragmentButton: Button
        get() = findViewById(R.id.toggleFragmentButton)

    private var isFragmentAVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener { nextButtonClick() }
        val loginButton = findViewById<TextView>(R.id.registernow)
        loginButton.setOnClickListener {
            navigateToRegistration()
        }

        // İlk fragment olarak FragmentA'yı yükle
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, FragmentA())
        }

        // Toggle button için tıklama işlemi
        toggleFragmentButton.setOnClickListener {
            toggleFragment()
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

    private fun toggleFragment() {
        val fragment: Fragment = if (isFragmentAVisible) {
            FragmentB()
        } else {
            FragmentA()
        }
        isFragmentAVisible = !isFragmentAVisible

        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, fragment)
        }
    }

    private fun navigateToRegistration() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
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
