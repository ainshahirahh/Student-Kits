package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class healthcareManual extends AppCompatActivity {

    ImageButton usermanNext;
    ImageButton usermanPrev;
    ImageButton homeManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare_manual);

        usermanNext = (ImageButton) findViewById(R.id.usermanNext);
        usermanPrev = (ImageButton) findViewById(R.id.usermanPrev);
        homeManual = (ImageButton) findViewById(R.id.homegeneral);

        usermanPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthcareManual.this, busScheduleManual.class);
                startActivity(intentLoadNewActivity);
            }
        });

        usermanNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthcareManual.this, remindermanual.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homeManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthcareManual.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}