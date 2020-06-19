package com.example.a711;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView currentTime;
    private Button btnSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTime = findViewById(R.id.text_current_time);
        btnSync = findViewById(R.id.btn_sync);
        currentTime.setText(getTime());

        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                int hour = Integer.parseInt(getHour());

                if (hour >= 6 && hour < 14) {
                    intent.setData(Uri.parse("http://morning"));
                }
                if (hour >= 14 && hour < 15) {
                    intent.setData(Uri.parse("http://afternoon"));
                }
                if (hour >= 15 && hour < 6) {
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });
    }

    public String getTime() {
        Date timeNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm");
        String time = formatForDateNow.format(timeNow);
        return time;
    }

    public String getHour() {
        Date hourNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh");
        String hour = formatForDateNow.format(hourNow);
        return hour;
    }
}