package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class usermanual extends AppCompatActivity {

    ImageButton usermanNext;
    ImageButton usermanPrev;
    ImageButton homeManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermanual);

        usermanNext = (ImageButton) findViewById(R.id.usermanNext);
        usermanPrev = (ImageButton) findViewById(R.id.usermanPrev);
        homeManual = (ImageButton) findViewById(R.id.homegeneral);

        usermanNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(usermanual.this, busScheduleManual.class);
                startActivity(intentLoadNewActivity);
            }
        });

        usermanPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(usermanual.this, emergecallManual.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homeManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(usermanual.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}