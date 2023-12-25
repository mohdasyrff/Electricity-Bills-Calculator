package com.example.electricitybills;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateBills extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bills);

        final EditText consumptionEditText = findViewById(R.id.consumptionEditText);
        final EditText rebateEditText = findViewById(R.id.rebateEditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        final TextView resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String consumptionStr = consumptionEditText.getText().toString();
                String rebateStr = rebateEditText.getText().toString();

                if (consumptionStr.isEmpty() || rebateStr.isEmpty()) {
                    // Display an error message
                    resultTextView.setText("Please enter both consumption and rebate.");
                } else {
                    double consumption = Double.parseDouble(consumptionStr);
                    double rebate = Double.parseDouble(rebateStr);

                    double totalBill = 0;

                    if (consumption <= 200) {
                        totalBill = consumption * 0.218;
                    }
                    else if (consumption >= 201 && consumption <= 300) {
                        totalBill = (200 * 0.218) + ((consumption - 200) * 0.334);
                    }
                    else if (consumption >= 301 && consumption <= 600) {
                        totalBill = (200 * 0.218) + (100 * 0.334) + ((consumption - 300) * 0.516);
                    }
                    else {
                        totalBill = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((consumption - 600) * 0.546);
                    }

                    double rebatePercent = rebate / 100;
                    double finalCost = totalBill - (totalBill * rebatePercent);

                    // Display result
                    resultTextView.setText(String.format("Total Bills: RM%.2f", finalCost));

                    // Show Toast
                    Toast.makeText(CalculateBills.this, "Total Cost: RM" + String.format("%.2f", finalCost), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}