package com.chat.laptop.hivego.services.services_tab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.date_time_fragment.CategoriesAdapter;
import com.chat.laptop.hivego.general.WrapContentViewPager;


public class ServicesTabFragment extends Fragment
{

    ViewPager viewPager;
    TabLayout tabLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services_tab, container, false);

        setupViewPager(view);

        return view;
    }


    private void setupViewPager(View view)
    {
        viewPager = (ViewPager) view.findViewById(R.id.pager);

         tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("HAIR CARE"));
        tabLayout.addTab(tabLayout.newTab().setText("FACE"));
        tabLayout.addTab(tabLayout.newTab().setText("MAKEUP"));
        tabLayout.addTab(tabLayout.newTab().setText("NAIL"));
        tabLayout.addTab(tabLayout.newTab().setText("BODY"));
        tabLayout.addTab(tabLayout.newTab().setText("MASSAGE AND SPA"));
        tabLayout.addTab(tabLayout.newTab().setText("EXCLUSIVE OFFERS"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ServicesTabAdapter adapter = new ServicesTabAdapter(getChildFragmentManager() , tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {

            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });



    }


}
