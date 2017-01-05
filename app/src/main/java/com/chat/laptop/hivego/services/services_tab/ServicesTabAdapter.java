package com.chat.laptop.hivego.services.services_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chat.laptop.hivego.date_time_fragment.ChooseDateFragment;
import com.chat.laptop.hivego.services.nailfragment.NailFragment;

/**
 * Created by John on 11/7/2016.
 */
public class ServicesTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private NailFragment nailFragment;

    public ServicesTabAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }



    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                nailFragment = new NailFragment();
                return nailFragment;
            case 1:
                nailFragment = new NailFragment();
                return nailFragment;
            default:
                nailFragment = new NailFragment();
                return nailFragment;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}