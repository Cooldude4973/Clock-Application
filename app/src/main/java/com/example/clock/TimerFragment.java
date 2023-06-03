package com.example.clock;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.awt.font.NumericShaper;
import java.util.Locale;


public class TimerFragment extends Fragment {


    boolean isStarted = false;
    int seconds = 0;
    TextView textView;
    public TimerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_timer, container, false);

        TextView textView =  (TextView) view.findViewById(R.id.timertext);
        Button button = (Button) view.findViewById(R.id.starttimerbutton);
        NumberPicker hourpicker = (NumberPicker) view.findViewById(R.id.hourtimer);
        NumberPicker minutepicker = (NumberPicker) view.findViewById(R.id.minutetimer);
        NumberPicker secondpicker = (NumberPicker) view.findViewById(R.id.secondtimer);
        hourpicker.setMinValue(0);
        hourpicker.setMaxValue(23);
        minutepicker.setMinValue(0);
        minutepicker.setMaxValue(59);
        secondpicker.setMinValue(0);
        secondpicker.setMaxValue(59);

        String[] hournumbers = new String[24];
        for(int i=0;i<24;i++)
        {
            if(i<10)
            {
                hournumbers[i] = String.valueOf("0"+i);
            }
            else
            {
                hournumbers[i] = String.valueOf(i);
            }

        }
        hourpicker.setDisplayedValues(hournumbers);

        String[] minsecnumbers = new String[60];
        for(int i=0;i<60;i++)
        {
            if(i<10)
            {
                minsecnumbers[i] = String.valueOf("0"+i);
            }
            else
            {
                minsecnumbers[i] = String.valueOf(i);
            }

        }
        minutepicker.setDisplayedValues(minsecnumbers);
        secondpicker.setDisplayedValues(minsecnumbers);
//
//        if(!isStarted)
//        {
//            hourpicker.setAlpha(1);
//            minutepicker.setAlpha(1);
//            secondpicker.setAlpha(1);
//            textView.setAlpha(0);
//        }

        startTimer(textView , hourpicker , minutepicker ,secondpicker);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hourspicked = hourpicker.getValue();
                int minutespicked = minutepicker.getValue();
                int secondspicked = secondpicker.getValue();
                seconds = hourspicked*(60*60) + minutespicked*(60) + secondspicked;
                textView.setAlpha(1);
                hourpicker.setAlpha(0);
                minutepicker.setAlpha(0);
                secondpicker.setAlpha(0);
//                Toast.makeText(getActivity(),hours+" "+minutes+" "+seconds,Toast.LENGTH_SHORT).show();
                isStarted = true;

            }
        });

                return view;

    }
    public void  startTimer(TextView textView, NumberPicker h , NumberPicker m , NumberPicker s)
    {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if(isStarted)
                {
                    if(seconds == 0)
                    {
                        isStarted = false;

                    }
                    else
                    {
                        seconds--;
                    }

                }
                else if(seconds == 0)
                {
                    timerEnd(textView ,h,m,s);
                }
                int h = seconds/(60*60);
                int m = seconds/60;
                int s = seconds%60;
                String stringFormat = String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
                textView.setText(stringFormat);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);

    }

    public void timerEnd(TextView textView , NumberPicker h , NumberPicker m , NumberPicker s)
    {
        textView.setAlpha(0);
        h.setAlpha(1);
        m.setAlpha(1);
        s.setAlpha(1);
    }


}