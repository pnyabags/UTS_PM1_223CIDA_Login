package com.example.utspemob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.util.Log

class RegisterPage : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_page)

        val loginTextView = findViewById<TextView>(R.id.loginTextView)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditTextR)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditTextR)
        val konfirmpasswordEditText = findViewById<EditText>(R.id.konfirmpasswordEditTextR)

        val registerButton = findViewById<Button>(R.id.registerButton)

        sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        registerButton.setOnClickListener {
            Log.d("RegisterPage", "Register Button Ditekan")
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val konfirmpassword = konfirmpasswordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (password != konfirmpassword) {
                    Toast.makeText(this, "Konfirmasi Password Berbeda", Toast.LENGTH_SHORT).show()
                } else {
                val editor = sharedPref.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Akun berhasil disimpan", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginPage::class.java))
                finish()
                }
            } else {
                Toast.makeText(this, "Isi semua data", Toast.LENGTH_SHORT).show()
            }
        }

        loginTextView.setOnClickListener {
            Log.d("LoginPage", "User Diarahkan Ke Login Page")
            Toast.makeText(this, "Selamat Datang Di Login Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}