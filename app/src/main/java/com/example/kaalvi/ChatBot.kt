package com.example.kaalvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ChatBot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        supportActionBar?.hide()
    }
}