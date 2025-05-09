package com.example.utspemob

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }, 4000)
    }
}