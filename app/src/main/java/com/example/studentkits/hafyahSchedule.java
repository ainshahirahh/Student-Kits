package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hafyahSchedule extends AppCompatActivity {

    ImageButton hafyahBack;
    ImageButton homehafyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafyah_schedule);


        hafyahBack = (ImageButton) findViewById(R.id.hafyahBack);
        homehafyah = (ImageButton) findViewById(R.id.homehafyah);

        hafyahBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(hafyahSchedule.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homehafyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(hafyahSchedule.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}