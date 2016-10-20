package com.chat.laptop.hivego.date_time_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.chat.laptop.hivego.dashboard.fragment.GenderFragment;


/**
 * Created by John on 9/1/2016.
 */
public class CategoriesAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;

    public CategoriesAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {

        switch (position)
        {
            case 0:
                GenderFragment special = new GenderFragment();
                return special;
            case 1:
                GenderFragment sellings = new GenderFragment();
                return sellings;
            case 2:
                GenderFragment favourite = new GenderFragment();
                return favourite;
            case 3:
                GenderFragment profile = new GenderFragment();
                return profile;
            case 4:
                GenderFragment favourite2 = new GenderFragment();
                return favourite2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}