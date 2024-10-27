package com.example.spacesbyyg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var bookTimeButton: Button
    private lateinit var adminPortalButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to your main activity layout
        setContentView(R.layout.activity_main)

        // Get references to the buttons
        bookTimeButton = findViewById(R.id.bookTimeButton)
        adminPortalButton = findViewById(R.id.adminPortalButton)

        // Navigate to Room Selection when "Book Time" is pressed
        bookTimeButton.setOnClickListener {
            val intent = Intent(this, RoomSelectionActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Admin Portal or Login based on authentication state
        adminPortalButton.setOnClickListener {
            val auth = FirebaseAuth.getInstance()
            if (auth.currentUser != null) {
                // User is already signed in, go directly to AdminPortalActivity
                val intent = Intent(this, AdminPortalActivity::class.java)
                startActivity(intent)
            } else {
                // User not signed in, go to login
                val intent = Intent(this, AdminLoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
