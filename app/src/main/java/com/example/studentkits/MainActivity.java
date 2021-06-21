package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageButton exitBtn;
    ImageButton userManualBtn;
    ImageButton infoMainBtn;

    private FirebaseAuth firebaseAuth;

    ImageButton basBtn;
    ImageButton healthBtn;
    ImageButton reminderBtn;
    ImageButton pdffBtn;
    ImageButton mcafeBtn;
    ImageButton ecallBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        exitBtn = (ImageButton) findViewById(R.id.exitButton);

        userManualBtn = (ImageButton) findViewById(R.id.userManualBtn);
        infoMainBtn = (ImageButton) findViewById(R.id.infoMainBtn);
        basBtn = (ImageButton) findViewById(R.id.basBtn);
        healthBtn = (ImageButton) findViewById(R.id.healthBtn);
        reminderBtn= (ImageButton) findViewById(R.id.reminderBtn);
        pdffBtn = (ImageButton) findViewById(R.id.pdffBtn);
        mcafeBtn = (ImageButton) findViewById(R.id.mcafeBtn);
        ecallBtn = (ImageButton) findViewById(R.id.ecallBtn);


        userManualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, usermanual.class);
                startActivity(intentLoadNewActivity);
            }
        });

        infoMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, appInfo.class);
                startActivity(intentLoadNewActivity);
            }
        });

        basBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, busSchedule.class);
                startActivity(intentLoadNewActivity);
            }
        });

        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, healthMain.class);
                startActivity(intentLoadNewActivity);
            }
        });

        reminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, expressReminder.class);
                startActivity(intentLoadNewActivity);
            }
        });

        pdffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, cloudpdf.class);
                startActivity(intentLoadNewActivity);
            }
        });


        mcafeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });

        ecallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, emergeCall.class);
                startActivity(intentLoadNewActivity);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == exitBtn) {
                    firebaseAuth.signOut();
                    finish();
                }
                Intent intentLoadNewActivity = new Intent(MainActivity.this, loginUser.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}