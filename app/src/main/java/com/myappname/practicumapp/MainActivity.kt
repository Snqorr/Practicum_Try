package com.myappname.practicumapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var WelcomeText: TextView
    private lateinit var imageView: ImageView
    private lateinit var SecondScreenBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        WelcomeText = findViewById(R.id.WelcomeText)
        imageView = findViewById(R.id.imageView)
        SecondScreenBtn = findViewById(R.id.SecondScreenBtn)

        SecondScreenBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}