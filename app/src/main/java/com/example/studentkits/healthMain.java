package com.example.studentkits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class healthMain extends AppCompatActivity {

    ImageButton healthMBack;
    ImageButton generalInfo;
    ImageButton healthCare;
    ImageButton xray;
    ImageButton dental;
    Button emergHealthBtn;
    private TextView textHealthCentre;
    private static final int REQUEST_CALL = 1;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_main);

        healthMBack = (ImageButton) findViewById(R.id.healthMBack);
        generalInfo = (ImageButton) findViewById(R.id.generalInfo);
        healthCare = (ImageButton) findViewById(R.id.healthCare);
        xray = (ImageButton) findViewById(R.id.xray);
        dental = (ImageButton) findViewById(R.id.dental);

        textHealthCentre = (TextView) findViewById(R.id.textHealthCentre);
        emergHealthBtn = (Button) findViewById(R.id.emergHealthBtn);

        healthMBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthMain.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        generalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthMain.this, generalInfo.class);
                startActivity(intentLoadNewActivity);
            }
        });

       healthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthMain.this, clinicCare.class);
                startActivity(intentLoadNewActivity);
            }
        });

        xray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthMain.this, xrayActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        dental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(healthMain.this, dentalCare.class);
                startActivity(intentLoadNewActivity);
            }
        });

        emergHealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallHealthCentre();
            }
        });

    }

    private void CallHealthCentre() {
        String number = textHealthCentre.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(healthMain.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(healthMain.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallHealthCentre();
            } else {
                Toast.makeText(this, "YOUR CALL ARE DENIED!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

