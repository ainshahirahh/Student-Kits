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

public class emergeCall extends AppCompatActivity {

    private ImageButton ecallBack;
    private Button osemBtn;
    private TextView textOsem;
    private Button finUgPgBtn;
    private Button finSchoBtn;
    private TextView textFinScho;
    private TextView textFinUgPg;
    private Button itdBtn;
    private TextView textItd;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emerge_call);

        ecallBack = (ImageButton) findViewById(R.id.ecallBack);

        textOsem = (TextView) findViewById(R.id.textOsem);
        osemBtn = (Button) findViewById(R.id.osemBtn);

        finUgPgBtn = (Button) findViewById(R.id.finUgPgBtn);
        finSchoBtn = (Button) findViewById(R.id.finSchoBtn);
        textFinScho = (TextView) findViewById(R.id.textFinScho);
        textFinUgPg = (TextView) findViewById(R.id.textFinUgPg);

        itdBtn = (Button) findViewById(R.id.itdBtn);
        textItd = (TextView) findViewById(R.id.textItd);

        ecallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(emergeCall.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        osemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallOsem();
            }
        });

        finUgPgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFinUgPg();
            }
        });

        finSchoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFinScho();
            }
        });

        itdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallItd();
            }
        });
    }

    private void CallOsem() {
        String number = textOsem.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(emergeCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(emergeCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallFinUgPg() {
        String number = textFinUgPg.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(emergeCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(emergeCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallFinScho() {
        String number = textFinScho.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(emergeCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(emergeCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallItd() {
        String number = textItd.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(emergeCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(emergeCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
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
                CallOsem();
                CallFinUgPg();
                CallFinScho();
                CallItd();
            } else {
                Toast.makeText(this, "YOUR CALL ARE DENIED!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}



