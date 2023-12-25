package com.example.electricitybills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.calculateButton);
        Button aboutButton = findViewById(R.id.aboutButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open CalculateActivity when Calculate Button is clicked
                Intent intent = new Intent(MainActivity.this, CalculateBills.class);
                startActivity(intent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AboutActivity when About Button is clicked
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }
}