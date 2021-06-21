package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class farouqZubairMenu extends AppCompatActivity {

    View view;
    ImageButton homeMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farouq_zubair_menu);

        homeMenu = (ImageButton) findViewById(R.id.homeMenu);

        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(farouqZubairMenu.this, mainCafe.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
