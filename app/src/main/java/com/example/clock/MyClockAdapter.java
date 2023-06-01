package com.example.clock;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyClockAdapter extends FragmentStateAdapter {

    public MyClockAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
            if(position == 0) return new AlarmFragment();
            else if(position == 1) return new WorldClockFragment();
            else if(position ==2 ) return new StopWatchFragment();
            else if(position == 3) return new TimerFragment();
            else return new SettingFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
