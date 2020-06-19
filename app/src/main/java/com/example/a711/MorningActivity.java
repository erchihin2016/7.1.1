package com.example.a711;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a711.R;

public class MorningActivity extends AppCompatActivity {
    private TextView mainTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        mainTxt = findViewById(R.id.text_main_morning);
    }
}
