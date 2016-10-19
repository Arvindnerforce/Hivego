package com.chat.laptop.hivego.dashboard;


import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.dashboard.fragment.GenderFragment;
import com.chat.laptop.hivego.dashboard.fragment.SearchCityFragment;
import com.chat.laptop.hivego.dashboard.navigation.NavigationFragment;


public class DashboardActivity extends AppCompatActivity
{
    //Defining Variables
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationFragment drawer;
    TextView toolbar_title_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);
        toolbar_title_txt.setText("YOUR GENDER?");

        setup_font();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        setupNavigationCustom();

        GenderFragment fragment = new GenderFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();




    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);

    }

    private void setupNavigationCustom()
    {
        drawer = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        drawer.setup(R.id.fragment, (DrawerLayout) findViewById(R.id.drawer), toolbar);
    }



}