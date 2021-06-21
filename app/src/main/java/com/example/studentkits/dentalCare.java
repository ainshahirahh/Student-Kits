package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class dentalCare extends AppCompatActivity {

    ImageButton dentalBack;
    ImageButton homedental;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_care);

        dentalBack = (ImageButton) findViewById(R.id.dentalBack);
        homedental = (ImageButton) findViewById(R.id.homedental);

        dentalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(dentalCare.this, healthMain.class);
                startActivity(intentLoadNewActivity);
            }
        });

        homedental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(dentalCare.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}
