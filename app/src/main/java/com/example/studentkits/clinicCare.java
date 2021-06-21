package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class clinicCare extends AppCompatActivity {

    ImageButton clinicBack;
    ImageButton homeclinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_care);

        clinicBack = (ImageButton) findViewById(R.id.clinicBack);
        homeclinic = (ImageButton) findViewById(R.id.homeclinic);

        clinicBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(clinicCare.this, healthMain.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homeclinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(clinicCare.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}