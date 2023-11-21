package com.example.kaalvi

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class UsersDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_data)
        supportActionBar?.hide()

        val name = intent.getStringExtra(Login.KEYName).toString()
        val number = intent.getStringExtra(Login.KEYNumber).toString()

        val usersDataName = findViewById<TextView>(R.id.UsersName)
        val usersDataNumber = findViewById<TextView>(R.id.UsersNumber)

        usersDataName.text = "Name: $name"
        usersDataNumber.text = "Number: $number"

        val calendar = findViewById<Button>(R.id.calendar_btn)
        val logout = findViewById<Button>(R.id.logout_btn)

        calendar.setOnClickListener {
            val intent = Intent(this,Calendar::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener{
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to Close the App")
            builder1.setIcon(R.drawable.baseline_exit_to_app)
            builder1.setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder1.show()
        }
    }
}