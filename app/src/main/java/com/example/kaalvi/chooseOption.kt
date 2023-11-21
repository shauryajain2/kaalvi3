package com.example.kaalvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class chooseOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitychooseoption)

        supportActionBar?.hide()
        val openSecondActivityButton = findViewById<Button>(R.id.login)
        openSecondActivityButton.setOnClickListener {
            // Create an Intent to open the SecondActivity
            val intent = Intent(this@chooseOption, Login::class.java)
            startActivity(intent)
        }

        val openSignUpActivityButton = findViewById<Button>(R.id.signup)
        openSignUpActivityButton.setOnClickListener {
            val intent = Intent(this@chooseOption,SignUp::class.java)
            startActivity(intent)
        }
    }
}