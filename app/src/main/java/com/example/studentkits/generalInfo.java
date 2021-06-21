package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class generalInfo extends AppCompatActivity {

    ImageButton generalBack;
    ImageButton homegeneral;
    Button covid19;
    Button vaccine1;
    Button vaccine2;
    Button vaccine3;
    Button vaccine4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);

        generalBack = (ImageButton) findViewById(R.id.generalBack);
        homegeneral = (ImageButton) findViewById(R.id.homegeneral);
        covid19 = (Button) findViewById(R.id.covid19);
        vaccine1 = (Button) findViewById(R.id.vaccine1);
        vaccine2 = (Button) findViewById(R.id.vaccine2);
        vaccine3 = (Button) findViewById(R.id.vaccine3);
        vaccine4 = (Button) findViewById(R.id.vaccine4);

        generalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, healthMain.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homegeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

       covid19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, covidInfo.class);
                startActivity(intentLoadNewActivity);
            }
        });

        vaccine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, vaccineInfo.class);
                startActivity(intentLoadNewActivity);
            }
        });

        vaccine2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, vaccineInfo2.class);
                startActivity(intentLoadNewActivity);
            }
        });

        vaccine3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, vaccineInfo3.class);
                startActivity(intentLoadNewActivity);
            }
        });

        vaccine4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(generalInfo.this, vaccineInfo4.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }

}