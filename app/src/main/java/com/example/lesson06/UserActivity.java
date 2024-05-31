package com.example.lesson06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        User user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            ((TextView) findViewById(R.id.tvUsername)).setText("Username: " + user.getUsername());
            ((TextView) findViewById(R.id.tvEmail)).setText("Email: " + user.getEmail());
            ((TextView) findViewById(R.id.tvPhone)).setText("Phone: " + user.getPhone());
            ((TextView) findViewById(R.id.tvCity)).setText("City: " + user.getAddress().getCity());
            ((TextView) findViewById(R.id.tvCompanyName)).setText("Company name: " + user.getCompany().getName());
        }
        findViewById(R.id.btnBack).setOnClickListener(x->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
