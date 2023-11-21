package com.example.kaalvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    companion object{
        const val KEYName="com.example.firebase.SignInActivity.name"
        const val KEYNumber="com.example.firebase.SignInActivity.number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val mobileNumber = findViewById<TextInputEditText>(R.id.mobileNumber)
        val password = findViewById<TextInputEditText>(R.id.passw)
        val loginBtn = findViewById<TextView>(R.id.login)

        loginBtn.setOnClickListener {
            val number = mobileNumber.text.toString()
            val pass = password.text.toString()

            if(number.isNotEmpty()){
                readData(number)
            }
            else{
                Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show()
            }
        }
        }

    private fun readData(number: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(number).get().addOnSuccessListener {

            if(it.exists()){
                val name=it.child("name").value
                val mobNumber=it.child("number").value
                val password=it.child("password").value

                val intent=Intent(this, HomePage::class.java)
                intent.putExtra(KEYName, name.toString())
                intent.putExtra(KEYNumber, number.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"User does not exist, Please Sign Up",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}