package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hafsahSafiyyahMenu extends AppCompatActivity {

    ImageButton homeMenu;
    ImageButton menuNext;
    ImageButton menuPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafsah_safiyyah_menu);

        homeMenu = (ImageButton) findViewById(R.id.homeMenu);

        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(hafsahSafiyyahMenu.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });

        menuNext = (ImageButton) findViewById(R.id.menuNext);
        menuPrev = (ImageButton) findViewById(R.id.menuPrev);

        menuPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(hafsahSafiyyahMenu.this, hafsahSafiyyahMenu2.class);
                startActivity(intentLoadNewActivity);
            }
        });

        menuNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(hafsahSafiyyahMenu.this, hafsahSafiyyahMenu2.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}