package com.example.opscassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import com.example.opscassignment.Login
import com.example.opscassignment.Register
import android.os.Handler
import android.os.Looper
import android.widget.Button


class Splash : AppCompatActivity() {

    // Duration the splash screen will show (in milliseconds)
    private val splashDelay: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        val registerButton = findViewById<Button>(R.id.btnRegister)
        val loginButton = findViewById<Button>(R.id.btnLoggin)

        registerButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Delay navigation after the splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            if (isUserLoggedIn()) {
                // User is logged in, navigate to the Main Dashboard (replace with your actual dashboard activity)
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // User is not logged in, navigate to the Login screen
                startActivity(Intent(this, Login::class.java))
            }
            finish() // Close the splash activity so the user can't go back to it
        }, splashDelay)
    }

    // Replace this with your actual user login status check (e.g., SharedPreferences, Firebase)
    private fun isUserLoggedIn(): Boolean {
        // Example using SharedPreferences to check if a login token exists
        val sharedPref = getSharedPreferences("SmartSpendPrefs", MODE_PRIVATE)
        return sharedPref.getBoolean("isLoggedIn", false) // Adjust key as needed
    }
}
