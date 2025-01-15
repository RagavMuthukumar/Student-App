package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private ImageView googleIcon, fbIcon, xIcon, appLogo;
    private TextView titleText, signUpLink, forgotPasswordLink;
    private EditText emailInput, passwordInput;
    private Button loginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI components using their IDs
        googleIcon = findViewById(R.id.googleIcon);
        fbIcon = findViewById(R.id.fbIcon);
        xIcon = findViewById(R.id.xIcon);
        appLogo = findViewById(R.id.appLogo);
        titleText = findViewById(R.id.titleText);
        signUpLink = findViewById(R.id.signUpLink);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // Set up event listeners for login button
        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            // Validate email and password
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(MainActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 8) {
                Toast.makeText(MainActivity.this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show();
            } else {
                // Use Firebase Authentication to sign in the user
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                // Login successful
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                // Proceed to another activity (e.g., dashboard or home screen)

                            } else {
                                // Login failed
                                Toast.makeText(MainActivity.this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Set OnClickListener for Forgot Password Link
        forgotPasswordLink.setOnClickListener(v -> {
            // Navigate to Forgot Password screen or show dialog
            Toast.makeText(MainActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            // Example Intent (if implemented):
            // Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            // startActivity(intent);
        });

        // Set OnClickListener for Sign Up Link
        signUpLink.setOnClickListener(v -> {
            // Navigate to Sign Up screen
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        // Handle Social Media Icon Click (Google)
        googleIcon.setOnClickListener(v -> {
            // Handle Google Login or action
            Toast.makeText(MainActivity.this, "Google Icon clicked", Toast.LENGTH_SHORT).show();
        });

        // Handle Social Media Icon Click (Facebook)
        fbIcon.setOnClickListener(v -> {
            // Handle Facebook Login or action
            Toast.makeText(MainActivity.this, "Facebook Icon clicked", Toast.LENGTH_SHORT).show();
        });

        // Handle Social Media Icon Click (Twitter)
        xIcon.setOnClickListener(v -> {
            // Handle Twitter Login or action
            Toast.makeText(MainActivity.this, "Twitter Icon clicked", Toast.LENGTH_SHORT).show();
        });
    }
}
