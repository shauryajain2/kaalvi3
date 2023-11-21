package com.example.kaalvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp2 : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        supportActionBar?.hide()

        val password = findViewById<TextInputEditText>(R.id.pass)
        val confirmPassword = findViewById<TextInputEditText>(R.id.confirmPass)
        val signUpBtn = findViewById<TextView>(R.id.signUp)

        val name = intent.getStringExtra(SignUp.keyName).toString()
        val number = intent.getStringExtra(SignUp.keyNumber).toString()

        signUpBtn.setOnClickListener {

            val pass = password.text.toString()
            val confirmPass = confirmPassword.text.toString()

            val user = User(number, name, pass)
            if (pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    database = FirebaseDatabase.getInstance().getReference("Users")
                    database.child(number).setValue(user).addOnSuccessListener {
                        Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    }.addOnFailureListener {
                        Toast.makeText(this, " Failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not Match..", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}