package com.chat.laptop.hivego.services;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

import java.util.ArrayList;

public class MenServicesFragment extends Fragment
{

    TextView toolbar_title_txt;
    RecyclerView men_recyclerview;
    MenServicesAdapter menServicesAdapter;
    public static ArrayList<MenServicesData> menServicesData = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_men_services, container, false);

        setuptoolbar(view);
        setServicesData();
        setup_recyclerview(view);
        setup_font(view);

        return view;
    }

    private void setup_recyclerview(View view)
    {

        men_recyclerview = (RecyclerView) view.findViewById(R.id.men_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        men_recyclerview.setLayoutManager(mLayoutManager);

        menServicesAdapter = new MenServicesAdapter(getActivity(), menServicesData);


        men_recyclerview.setAdapter(menServicesAdapter);
    }

    private void setServicesData()
    {

        try {
            menServicesData.clear();
        } catch (Exception ex) {
        }
        menServicesData.add(new MenServicesData(R.drawable.hair_care,"","HAIR CARE"));
        menServicesData.add(new MenServicesData(R.drawable.face, "", "FACE"));
        menServicesData.add(new MenServicesData(R.drawable.hair_care, "", "MAKEUP"));
        menServicesData.add(new MenServicesData(R.drawable.face, "", "NAIL"));
        menServicesData.add(new MenServicesData(R.drawable.hair_care, "", "BODY"));
        menServicesData.add(new MenServicesData(R.drawable.face, "", "MASSAGE AND SPA"));
        menServicesData.add(new MenServicesData(R.drawable.hair_care, "", "EXCLUSIVE OFFERS"));

    }

    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("SERVICES");

    }

    private void setup_font(View view) {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }



}
