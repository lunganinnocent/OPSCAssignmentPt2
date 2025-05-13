package com.example.opscassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import SQLiteHelper
import android.content.Intent
import android.widget.Toast
import com.example.opscassignment.MainActivity
import com.example.opscassignment.R


    class Register : AppCompatActivity() {
        private lateinit var dbHelper: SQLiteHelper // Use your specific helper class

        private lateinit var editTextFullName: EditText
        private lateinit var editTextPassword: EditText
        private lateinit var editTextConfirmPassword: EditText
        private lateinit var btnRegister: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)

            dbHelper = SQLiteHelper(this) // Initialize your SQLiteHelper

            editTextFullName = findViewById(R.id.editTextFullName)
            editTextPassword = findViewById(R.id.editTextPassword)
            editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
            btnRegister = findViewById(R.id.btnRegister)

            btnRegister.setOnClickListener {
                val fullName = editTextFullName.text.toString()
                val password = editTextPassword.text.toString()
                val confirmPassword = editTextConfirmPassword.text.toString()






                btnRegister.setOnClickListener {
                    val fullName = editTextFullName.text.toString()
                    val password = editTextPassword.text.toString()
                    val confirmPassword = editTextConfirmPassword.text.toString()

                    if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                        Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                }
        }
    }
}



