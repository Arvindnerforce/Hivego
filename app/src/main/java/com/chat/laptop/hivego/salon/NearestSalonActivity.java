package com.chat.laptop.hivego.salon;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.services.MenServicesActivity;
import com.chat.laptop.hivego.tutorial.ViewPagerAdapter;
import com.chat.laptop.hivego.unavailable.UnavailableActivity;


public class NearestSalonActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{


    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;
    TextView toolbar_title_txt,salonNametxt;
    Button continueButton,showAllButton;

    private int[] mImageResources = {
            R.drawable.salon_first,
            R.drawable.salon_second,
            R.drawable.salon_third,
            R.drawable.salon_forth,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nearest_salon);

        setuptoolbar();

        setup_layout();
        setReference();
        setup_font();


    }

    private void setup_layout()
    {

        continueButton = (Button) findViewById(R.id.continueButton);

        showAllButton = (Button) findViewById(R.id.showAllButton);

        salonNametxt = (TextView) findViewById(R.id.salonNametxt);

        continueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent otp = new Intent(NearestSalonActivity.this, MenServicesActivity.class);
                startActivity(otp);
            }
        });
    }


    public void setReference() {

        intro_images = (ViewPager) findViewById(R.id.pager_introduction);

        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        mAdapter = new ViewPagerAdapter(NearestSalonActivity.this, mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
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


    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);

        toolbar_title_txt.setText("NEAREST SALON");

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        toolbar_title_txt.setTypeface(tf);

        continueButton.setTypeface(tf);
        showAllButton.setTypeface(tf);
        salonNametxt.setTypeface(tf);



    }
}