package com.example.tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterClass extends FragmentPagerAdapter {

    private Context mycontext;
    int totalTabs;
    public AdapterClass(Context mycontext,@NonNull FragmentManager fm,int totalTabs ) {
        super(fm, totalTabs);
        this.mycontext = mycontext;
        this.totalTabs=totalTabs;


    }

    public static void main(String[] args) {

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;

            case 1:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 2:
                CallsFragment callsFragment = new CallsFragment();
                return callsFragment;

            default:
                StatusFragment statusFragment1 = new StatusFragment();
                return statusFragment1;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
