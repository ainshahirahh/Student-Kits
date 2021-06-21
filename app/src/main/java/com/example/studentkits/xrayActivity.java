package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class xrayActivity extends AppCompatActivity {

    ImageButton xrayBack;
    ImageButton homexray;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xray);

        xrayBack = (ImageButton) findViewById(R.id.xrayBack);
        homexray = (ImageButton) findViewById(R.id.homexray);

        xrayBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(xrayActivity.this, healthMain.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homexray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(xrayActivity.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }

}
