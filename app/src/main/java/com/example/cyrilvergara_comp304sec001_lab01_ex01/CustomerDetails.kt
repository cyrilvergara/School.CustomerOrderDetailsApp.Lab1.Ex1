package com.example.cyrilvergara_comp304sec001_lab01_ex01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_details)

        //get reference
        val etName = findViewById<EditText>(R.id.etNAme)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        //setup event listener
        btnLogin.setOnClickListener(){
            //create intent- used for nav to diff activity
            val intent = Intent(this, OrderDetails::class.java)
            intent.putExtra("NAME", etName.text.toString())
            intent.putExtra("EMAIL", etEmail.text.toString())
            intent.putExtra("ADDRESS", etAddress.text.toString())
            //pass intent ojb to startActivity method
            startActivity(intent)
        }// end event listener
    }// end onCreate()
}// end MainActivity