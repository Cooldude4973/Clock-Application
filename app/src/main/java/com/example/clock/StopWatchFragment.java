package com.example.clock;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;


public class StopWatchFragment extends Fragment {


    Context context;

    TextView textView;


//    int milliseconds = 0;
    int seconds = 0;
    boolean isRunning = false;
    public StopWatchFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_stopwatch, container, false);
        TextView textView = (TextView) view.findViewById(R.id.stopwatchtext);
        FloatingActionButton startButton = (FloatingActionButton) view.findViewById(R.id.playbutton);
        FloatingActionButton pauseButton = (FloatingActionButton) view.findViewById(R.id.pausebutton);
        FloatingActionButton stopButton = (FloatingActionButton) view.findViewById(R.id.stopbutton);
        startTimer(textView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = true;
                pauseButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.INVISIBLE);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;
//                milliseconds = 0;
                seconds = 0;
                pauseButton.setVisibility(View.INVISIBLE);
                stopButton.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
            }
        });

        return view;

    }




    public void startTimer(TextView textView)
    {
//        textView = (TextView) getView().findViewById(R.id.stopwatchtext);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int s = seconds%60;
                int m = seconds/60;
                int h = m/60;
//                int milli = milliseconds%1000;
//                int m = (milli/1000)/60;
//                int s = (milli/1000)%60;
//                int h = m/60;
//                if(isRunning){milliseconds++;}
                if(isRunning){seconds++;}

//                String stringFormat = String.format(Locale.getDefault(),"%02d:%02d:%02d:%02d",h,m,s,milli);
                String stringFormat = String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
                textView.setText(stringFormat);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }


}