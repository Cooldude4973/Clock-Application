package com.example.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(new MyClockAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                if(position == 0)
                {
//                    tab.setText("Alarm");
                    tab.setIcon(R.drawable.alarm_clock);
//                    tab.setCustomView(R.layout.customtabicon);
                }

                else if (position == 1)
                {
//                    tab.setText("World Clock");
                    tab.setIcon(R.drawable.worldclockoutlined);
//                    tab.setCustomView(R.layout.customtabicon);
                }
                else if(position ==2)
                {
//                    tab.setText("Stopwatch");
                    tab.setIcon(R.drawable.stopwatchoutlined);
//                   tab.setCustomView(R.layout.customtabicon);
                }
                else if(position == 3)
                {
//                    tab.setText("Timer");
                    tab.setIcon(R.drawable.hourglass);
//                    tab.setCustomView(R.layout.customtabicon);
                }
                else
                {
//                    tab.setText("Settings");
                    tab.setIcon(R.drawable.settingoutlined);
//                    tab.setCustomView(R.layout.customtabicon);
                }

            }
        }
        );
        tabLayoutMediator.attach();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                if(pos == 0) tab.setIcon(R.drawable.alarm_clock);
                if(pos == 1) tab.setIcon(R.drawable.worldclockfilled);
                if(pos == 2) tab.setIcon(R.drawable.stopwatchfilled);
                if(pos == 3) tab.setIcon(R.drawable.hourglassfilled);
                if(pos == 4) tab.setIcon(R.drawable.setting);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                if(pos == 0) tab.setIcon(R.drawable.alarm_clock_outlined);
                if(pos == 1) tab.setIcon(R.drawable.worldclockoutlined);
                if(pos == 2) tab.setIcon(R.drawable.stopwatchoutlined);
                if(pos == 3) tab.setIcon(R.drawable.hourglass);
                if(pos == 4) tab.setIcon(R.drawable.settingoutlined);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}