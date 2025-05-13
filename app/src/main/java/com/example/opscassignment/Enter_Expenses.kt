package com.example.opscassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.*
import com.example.opscassignment.R.*
import java.text.SimpleDateFormat
import java.util.*


class Enter_Expenses : AppCompatActivity() {
    private lateinit var amountEditText: EditText
    private lateinit var dateButton: Button
    private lateinit var categorySpinner: Spinner
    private lateinit var saveButton: Button
    private lateinit var attachReceiptButton: Button

    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)

    //remember to remove this later as it only hides the problem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_enter_expenses)

        amountEditText = findViewById(id.etAmount) /// the problem
        dateButton = findViewById(id.etDate)
        categorySpinner = findViewById(id.etCategory)
        saveButton = findViewById(id.btnSaveExpense)
        attachReceiptButton = findViewById(id.btnAttachReceipt)

        // Spinner setup
        val categories = arrayOf("Transport", "Food", "Groceries", "Utilities", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)
        categorySpinner.adapter = adapter

        // Date picker dialog
        dateButton.setOnClickListener {
            val datePicker = DatePickerDialog(this,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    dateButton.text = dateFormat.format(calendar.time)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        saveButton.setOnClickListener {
            val amount = amountEditText.text.toString()
            val date = dateButton.text.toString()
            val category = categorySpinner.selectedItem.toString()

            if (amount.isEmpty() || date == "Select Date") {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Expense Saved: $amount, $date, $category", Toast.LENGTH_SHORT).show()
                // Save logic can go here (e.g., database, API call)
            }
        }

        attachReceiptButton.setOnClickListener {
            Toast.makeText(this, "Attach Receipt clicked", Toast.LENGTH_SHORT).show()
            // You can implement image picker or camera here
        }
    }
}

