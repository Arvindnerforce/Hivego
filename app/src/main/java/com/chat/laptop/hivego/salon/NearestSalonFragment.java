package com.chat.laptop.hivego.salon;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import com.chat.laptop.hivego.R;

import com.chat.laptop.hivego.services.MenServicesData;
import com.chat.laptop.hivego.services.MenServicesFragment;
import com.chat.laptop.hivego.tutorial.ViewPagerAdapter;


public class NearestSalonFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener{


    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;
    TextView toolbar_title_txt,salonNametxt,title_txt;
    Button continueButton,showAllButton;

    private int[] mImageResources = {
            R.drawable.salon_first,
            R.drawable.salon_second,
            R.drawable.salon_third,
            R.drawable.salon_forth,

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearest_salon, container, false);

       setuptoolbar(view);

        setup_layout(view);
        setReference(view);
        setup_font();

        return view;
    }

    private void setup_layout(View view)
    {

        continueButton = (Button) view.findViewById(R.id.continueButton);

        showAllButton = (Button) view.findViewById(R.id.showAllButton);

        salonNametxt = (TextView) view.findViewById(R.id.salonNametxt);

        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalonListFragment salonListFragment = new SalonListFragment();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, salonListFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenServicesFragment menServicesFragment = new MenServicesFragment();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, menServicesFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();
            }
        });
    }


    public void setReference(View view) {

        intro_images = (ViewPager) view.findViewById(R.id.pager_introduction);

        pager_indicator = (LinearLayout) view.findViewById(R.id.viewPagerCountDots);

        mAdapter = new ViewPagerAdapter(getActivity(), mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.salonnonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.salonselecteditem_dot));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }


    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        title_txt.setText("NEAREST SALON");

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");

        title_txt.setTypeface(tf);

        continueButton.setTypeface(tf);
        showAllButton.setTypeface(tf);
        salonNametxt.setTypeface(tf);

    }



}