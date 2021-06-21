package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class fabairSchedule extends AppCompatActivity {

    ImageButton fabairBack;
    ImageButton homefabair;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabair_schedule);

        fabairBack = (ImageButton) findViewById(R.id.fabairBack);
        homefabair = (ImageButton) findViewById(R.id.homefabair);

        fabairBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(fabairSchedule.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homefabair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(fabairSchedule.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });



    }
}