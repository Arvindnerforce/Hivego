package com.chat.laptop.hivego.services;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

import java.util.ArrayList;

public class MenServicesActivity extends AppCompatActivity {

   TextView toolbar_title_txt;
    RecyclerView men_recyclerview;
    MenServicesAdapter menServicesAdapter;
    public static ArrayList<MenServicesData> menServicesData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_services);
        setuptoolbar();
        setFilterData();
        setup_recyclerview();
        setup_font();
    }

    private void setup_recyclerview()
    {

        men_recyclerview = (RecyclerView) findViewById(R.id.men_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        men_recyclerview.setLayoutManager(mLayoutManager);

        menServicesAdapter = new MenServicesAdapter(getApplicationContext(), menServicesData);


        men_recyclerview.setAdapter(menServicesAdapter);
    }

    private void setFilterData()
    {

        try {
            menServicesData.clear();
        } catch (Exception ex) {
        }
        menServicesData.add(new MenServicesData("hair_care","","HAIR CARE"));
        menServicesData.add(new MenServicesData("face", "", "FACE"));
        menServicesData.add(new MenServicesData("mackup", "", "MAKEUP"));
        menServicesData.add(new MenServicesData("nail", "", "NAIL"));
        menServicesData.add(new MenServicesData("body", "", "BODY"));
        menServicesData.add(new MenServicesData("massage_spa", "", "MASSAGE AND SPA"));
        menServicesData.add(new MenServicesData("exclusive_offer", "", "EXCLUSIVE OFFERS"));

    }

    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);

        toolbar_title_txt.setText("SERVICES");

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


}
