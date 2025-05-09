package com.example.utspemob

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginPage : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_page)

        sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditTextL)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditTextL)

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            Log.d("LoginPage", "Login Button Ditekan")
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)

            if (username == savedUsername && password == savedPassword) {
                Toast.makeText(this, "Selamat Datang di Artikel Mie Ayam", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        val registerTextView = findViewById<TextView>(R.id.registerTextView)

        registerTextView.setOnClickListener {
            Log.d("LoginPage", "User Diarahkan Ke Register Page")
            Toast.makeText(this, "Selamat Datang Di Register Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
            finish()
            }
        }
    }
}