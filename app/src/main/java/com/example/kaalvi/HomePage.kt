package com.example.kaalvi

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.annotation.RequiresApi
import pl.droidsonroids.gif.GifImageView

class HomePage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        supportActionBar?.hide()

        val chatBot = findViewById<GifImageView>(R.id.chatbot)

        chatBot.setOnClickListener {
            val intent = Intent(this, ChatBot::class.java)
            startActivity(intent)
        }
        val toolBar = findViewById<View>(R.id.Toolbar)
        toolBar.setOnClickListener {
            val intent = Intent(this, UsersDataActivity::class.java)
            startActivity(intent)
        }

        val Ambulance = findViewById<TextView>(R.id.textView2)
        val police = findViewById<TextView>(R.id.textView3)
        val excecutive = findViewById<TextView>(R.id.textView4)
        val Municipality = findViewById<TextView>(R.id.textView5)

        Ambulance.setOnClickListener() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + 108) //change the number.

            startActivity(callIntent)
        }
        police.setOnClickListener() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + 100) //change the number.

            startActivity(callIntent)
        }
        excecutive.setOnClickListener() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + 9027000507) //change the number.

            startActivity(callIntent)
        }
        Municipality.setOnClickListener() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + 7612672278) //change the number.

            startActivity(callIntent)
        }
        val webView = findViewById<WebView>(R.id.webView)
        webViewSetup(webView)

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(webView: WebView){
        webView.webViewClient = WebViewClient()
        webView.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://www.goindigo.in/")
        }
    }
}