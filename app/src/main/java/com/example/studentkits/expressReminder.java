package com.example.studentkits;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class expressReminder extends AppCompatActivity implements View.OnClickListener {

    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_reminder);

        findViewById(R.id.btnSet).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

    }
        @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.editText);
                TimePicker timePicker = findViewById(R.id.timePicker);

                Intent intent = new Intent(expressReminder.this, reminderReceiver.class);
                intent.putExtra("notificationId", notificationId);
                intent.putExtra("message", editText.getText().toString());

                PendingIntent alarmIntent = PendingIntent.getBroadcast(expressReminder.this, 0,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

                switch (view.getId()) {
                    case R.id.btnSet:
                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();

                        Calendar startTime = Calendar.getInstance();   //create the task duration
                        startTime.set(Calendar.HOUR_OF_DAY, hour);
                        startTime.set(Calendar.MINUTE, minute);
                        startTime.set(Calendar.SECOND, 0);
                        long alarmStartTime = startTime.getTimeInMillis();

                        //set the alarm
                        alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                        // setRepeating() the task reminder in next 5 minutes if user did not click it in mobile notification
                        alarm.setRepeating(AlarmManager.RTC_WAKEUP, startTime.getTimeInMillis(),
                                1000 * 60 * 5, alarmIntent);

                        Toast.makeText(expressReminder.this, "Set task is done!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.btnCancel:
                        alarm.cancel(alarmIntent);
                        Toast.makeText(expressReminder.this, "Set task is cancelled!", Toast.LENGTH_SHORT).show();
                        break;
                }

             }

    public void backBtn(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}