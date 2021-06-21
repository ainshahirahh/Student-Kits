package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class busSchedule extends AppCompatActivity {

    ImageButton backBtn;
    ImageButton fromRuqayyah;
    ImageButton infrontClinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);

        backBtn = (ImageButton) findViewById(R.id.backBtn);
        fromRuqayyah = (ImageButton) findViewById(R.id.fromRuqayyah);
        infrontClinic = (ImageButton) findViewById(R.id.infrontClinic);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(busSchedule.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        fromRuqayyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(busSchedule.this, fromRuqayyah.class);
                startActivity(intentLoadNewActivity);
            }
        });

        infrontClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(busSchedule.this, infrontClinic.class);
                startActivity(intentLoadNewActivity);
            }
        });


    }
}