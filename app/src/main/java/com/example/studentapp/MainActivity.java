package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private ImageView googleIcon, fbIcon, xIcon, appLogo;
    private TextView titleText, signUpLink;
    private EditText emailInput, passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components using their IDs
        googleIcon = findViewById(R.id.googleIcon);
        fbIcon = findViewById(R.id.fbIcon);
        xIcon = findViewById(R.id.xIcon);
        appLogo = findViewById(R.id.appLogo);
        titleText = findViewById(R.id.titleText);
        signUpLink = findViewById(R.id.signUpLink);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // Set up event listeners or other logic here

        // Example: Handle Login Button Click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditText
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                // You can now process the login or validation logic here
                if (email.isEmpty() || password.isEmpty()) {
                    // Show a toast or error message (for demonstration purposes)
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with login or validation logic
                    // e.g., validate user credentials
                }
            }
        });

        // Example: Set OnClickListener for Sign Up Link
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Sign Up screen or show Sign Up dialog
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // Example: Handle Social Media Icon Click (Google)
        googleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Google Login or action
                Toast.makeText(MainActivity.this, "Google Icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Example: Handle Social Media Icon Click (Facebook)
        fbIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Facebook Login or action
               Toast.makeText(MainActivity.this, "Facebook Icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Example: Handle Social Media Icon Click (Twitter)
        xIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Twitter Login or action
                Toast.makeText(MainActivity.this, "Twitter Icon clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
