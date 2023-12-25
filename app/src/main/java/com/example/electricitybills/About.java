package com.example.electricitybills;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button linkButton = findViewById(R.id.linkButton);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String githubUrl = "https://github.com/mohdasyrff";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));

                startActivity(intent);
            }
        });
    }
}