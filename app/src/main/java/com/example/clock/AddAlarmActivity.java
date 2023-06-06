package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddAlarmActivity extends AppCompatActivity {

    NumberPicker amPm ,  hourAlarm , minAlarm ;

    int hours_24;

    TextView topTime ;

    boolean amFlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        amPm = findViewById(R.id.ampm);
        hourAlarm = findViewById(R.id.houralarm);
        minAlarm = findViewById(R.id.minutealarm);
        topTime = findViewById(R.id.toptime); // Not done yet Difference between current time and time to  ring
        ImageView setAlarmButton = findViewById(R.id.setalarmbutton);

        amPm.setMinValue(1);
        amPm.setMaxValue(2);
        hourAlarm.setMinValue(1);
        hourAlarm.setMaxValue(12);
        minAlarm.setMinValue(0);
        minAlarm.setMaxValue(59);
        String morningornight[] = new String[2];
        morningornight[0] = "am";
        morningornight[1] = "pm";
        amPm.setDisplayedValues(morningornight);
        Calendar calendar = GregorianCalendar.getInstance();
        int hours = calendar.get(calendar.HOUR);
        hours_24 = calendar.get(calendar.HOUR_OF_DAY);
        hourAlarm.setValue(hours);
        int minutes = calendar.get(calendar.MINUTE);
        minAlarm.setValue(minutes);
        if(hours_24 < 12)
        {
            amFlag = true;
            amPm.setValue(1);
        }
        else
        {
            amFlag = false;
            amPm.setValue(2);
        }

        hourAlarm.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
//                if(oldVal == 11 && amFlag)
//                {
//                    amPm.setValue(2);
//                    amFlag = false;
//                }
//                else if(oldVal == 11 && !amFlag)
//                {
//                    amPm.setValue(1);
//                    amFlag = true;
//                }
//                if(hours_24 <= 24)
//                {
//                    hours_24++;
//                }
//                else
//                {
//                    hours_24 = 1;
//                }
//                if(hours_24 < 12) amPm.setValue(1);
//                else amPm.setValue(2);


            }
        });

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int alarmHours = hourAlarm.getValue();
                int alarmMinutes = minAlarm.getValue();
                Toast.makeText(AddAlarmActivity.this, "Alarm in "+alarmHours+" hours and "+alarmMinutes+" minutes", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout repeatLayout = findViewById(R.id.repeatlayout);

        repeatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment repeatAlarmFragment = new RepeatAlarmBottomFragment();
                repeatAlarmFragment.show(getSupportFragmentManager(), repeatAlarmFragment.getTag());

            }
        });



    }
}