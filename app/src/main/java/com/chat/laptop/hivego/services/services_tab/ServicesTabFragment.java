package com.chat.laptop.hivego.services.services_tab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.date_time_fragment.CategoriesAdapter;
import com.chat.laptop.hivego.general.WrapContentViewPager;


public class ServicesTabFragment extends Fragment
{

    WrapContentViewPager  viewPager;




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

        viewPager = (WrapContentViewPager) view.findViewById(R.id.pager);
        viewPager.setPagingEnabled(true);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_morning)).setText("HAIR"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_afternoon)).setText("FACE"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_evening)).setText("MAKEUP"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_moon)).setText("BODY"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_moon)).setText("MASSAGE AND SPA"));

        final int tabIconColor = ContextCompat.getColor(getActivity(), R.color.black);
        final int tabIconSelectedColor = ContextCompat.getColor(getActivity(), R.color.colorPrimary);


        tabLayout.getTabAt(0).getIcon().setColorFilter(tabIconSelectedColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final CategoriesAdapter adapter = new CategoriesAdapter(getChildFragmentManager() , tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {

            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(tabIconSelectedColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });



    }


}
