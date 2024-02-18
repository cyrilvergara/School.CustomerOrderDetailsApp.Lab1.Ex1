package com.example.cyrilvergara_comp304sec001_lab01_ex01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        // Get references
        val etProductName = findViewById<EditText>(R.id.etProductName)
        val etPricePerUnit = findViewById<EditText>(R.id.etPricePerUnit)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        // Retrieve from intent
        val intent = intent
        val etName = intent.getStringExtra("NAME")
        val etEmail = intent.getStringExtra("EMAIL")
        val etAddress = intent.getStringExtra("ADDRESS")

        // Set customer details to Output
        tvOutput.text =
            "Customer Details:\nName: $etName\nEmail: $etEmail\nAddress: $etAddress"

        // Event listener for btnCalculate
        btnCalculate.setOnClickListener {
            // Retrieve customer details from intent
            val intent = intent
            val etName = intent.getStringExtra("NAME")
            val etEmail = intent.getStringExtra("EMAIL")
            val etAddress = intent.getStringExtra("ADDRESS")

            // Customer details to Output
            tvOutput.text = "Customer Details:\nName: $etName\nEmail: $etEmail\nAddress: $etAddress"

            // Validate etQuantity
            val quantity = etQuantity.text.toString().toIntOrNull()
            if (quantity == null || quantity !in 1..10) {
                Toast.makeText(this, "Quantity should be between 1 and 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate etPricePerUnit
            val pricePerUnit = etPricePerUnit.text.toString().toDoubleOrNull()
            if (pricePerUnit == null || pricePerUnit <= 0) {
                Toast.makeText(this, "Price Per Unit should be greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate total price
            val totalPrice = quantity * pricePerUnit

            // Append order details in tvOutput
            tvOutput.append(
                "\n\nOrder Details:\nProduct Name: ${etProductName.text}\n" +
                        "Price per Unit: $pricePerUnit\nQuantity: $quantity\n\n" +
                        "Total Price: $totalPrice"
            )

            // Display Toast with customer details and order details
            Toast.makeText(
                this, "Customer Details:\nName: $etName\nEmail: $etEmail\nAddress: $etAddress" +
                        "\n\nOrder Details:\nProduct Name: ${etProductName.text}\n" +
                        "Price per Unit: $pricePerUnit\nQuantity: $quantity\n\n" +
                        "Total Price: $totalPrice", Toast.LENGTH_SHORT
            ).show()
        }
    }
}