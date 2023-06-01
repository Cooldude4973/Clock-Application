package com.example.clock;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        NumberPicker numberPicker1 = findViewById(R.id.houralarm);
        NumberPicker numberPicker2 = findViewById(R.id.minutealarm);
        numberPicker1.setMinValue(1);
        numberPicker1.setMaxValue(12);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            numberPicker1.setTextSize(72);
            numberPicker2.setTextSize(72);
        }
    }
}
