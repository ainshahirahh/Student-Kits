package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class appInfo extends AppCompatActivity {

    ImageButton infoBack;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        infoBack = (ImageButton) findViewById(R.id.infoBack);

        infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(appInfo.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }


}