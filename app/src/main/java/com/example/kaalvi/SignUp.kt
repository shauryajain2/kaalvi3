package com.example.kaalvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    companion object{
        const val keyNumber = "number"
        const val keyName = "name"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        val name = findViewById<EditText>(R.id.name)
        val number = findViewById<EditText>(R.id.number)
        val next = findViewById<TextView>(R.id.next)
        next.setOnClickListener{
            val n1 = name.text.toString()
            val num = number.text.toString()
            if(n1.isNotEmpty() && num.isNotEmpty() && num.length==10) {
                val intent = Intent(this, SignUp2::class.java)
                intent.putExtra(keyName, n1)
                intent.putExtra(keyNumber, num)
                startActivity(intent)
            }
            else if(n1.isNotEmpty() && num.isNotEmpty() && num.length!=10){
                Toast.makeText(this, "Enter a valid Phone number", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Please enter your details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}