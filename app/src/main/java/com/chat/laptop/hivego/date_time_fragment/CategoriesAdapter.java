package com.chat.laptop.hivego.date_time_fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chat.laptop.hivego.dashboard.fragment.GenderFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private GenderFragment genderFragment;

    public CategoriesAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }



    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                genderFragment = new GenderFragment();
                return genderFragment;
            case 1:
                genderFragment = new GenderFragment();
                return genderFragment;
            default:
                genderFragment = new GenderFragment();
                return genderFragment;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}