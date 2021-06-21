package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class amimahSchedule extends AppCompatActivity {

    ImageButton amimahBack;
    ImageButton homeamimah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amimah_schedule);

        amimahBack = (ImageButton) findViewById(R.id.amimahBack);
        homeamimah = (ImageButton) findViewById(R.id.homeamimah);

        amimahBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(amimahSchedule.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homeamimah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(amimahSchedule.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}