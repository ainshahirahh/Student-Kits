package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class mainCafe extends AppCompatActivity {

    ImageButton mcafeBack;
    ImageButton fabairMenu;
    ImageButton amimahMenu;
    ImageButton hafyahMenu;
    Button fabairBtn;
    Button amimahBtn;
    Button hafyahBtn;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cafe);


        mcafeBack = (ImageButton) findViewById(R.id.mcafeBack);
        fabairMenu = (ImageButton) findViewById(R.id.fabairMenu);
        amimahMenu = (ImageButton) findViewById(R.id.amimahMenu);
        hafyahMenu = (ImageButton) findViewById(R.id.hafyahMenu);
        fabairBtn = (Button) findViewById(R.id.fabairBtn);
        amimahBtn = (Button) findViewById(R.id.amimahBtn);
        hafyahBtn = (Button) findViewById(R.id.hafyahBtn);

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.whiteBg);


        mcafeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        fabairMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, farouqZubairMenu.class);
                startActivity(intentLoadNewActivity);
            }
        });

        fabairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, fabairSchedule.class);
                startActivity(intentLoadNewActivity);
            }
        });

        amimahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, amimahSchedule.class);
                startActivity(intentLoadNewActivity);
            }
        });

        amimahMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, aminahHalimahMenu.class);
                startActivity(intentLoadNewActivity);
            }
        });

        hafyahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, hafyahSchedule.class);
                startActivity(intentLoadNewActivity);
            }
        });

        hafyahMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(mainCafe.this, hafsahSafiyyahMenu.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}