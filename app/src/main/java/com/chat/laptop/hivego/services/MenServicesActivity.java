package com.chat.laptop.hivego.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.chat.laptop.hivego.R;

import java.util.ArrayList;

public class MenServicesActivity extends AppCompatActivity {


    RecyclerView men_recyclerview;
    MenServicesAdapter menServicesAdapter;
    public static ArrayList<MenServicesData> menServicesData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_services);

        setFilterData();
        setup_recyclerview();
    }

    private void setup_recyclerview() {

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
        menServicesData.add(new MenServicesData("","","HAIR CARE"));
        menServicesData.add(new MenServicesData("","","FACE"));
        menServicesData.add(new MenServicesData("","","MAKEUP"));
        menServicesData.add(new MenServicesData("","","NAIL"));
        menServicesData.add(new MenServicesData("","","BODY"));
        menServicesData.add(new MenServicesData("","","MASSAGE AND SPA"));
        menServicesData.add(new MenServicesData("","","EXCLUSIVE OFFERS"));

    }
}
