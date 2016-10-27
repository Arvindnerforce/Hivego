package com.chat.laptop.hivego.date_time_fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.confirm_fragment.ConfirmOrderFragment;
import com.chat.laptop.hivego.services.MenServicesAdapter;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;


public class ChooseDateFragment extends Fragment
{


    TextView toolbar_title_txt;
    Button scheduleButton;
    RecyclerView choose_recyclerview;
    ChooseDateAdapter chooseDateAdapter;
    public static ArrayList<ChooseDateData> choosedateData = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_date, container, false);
        setServicesData();
        setup_recyclerview(view);

        return view;
    }



    private void setup_recyclerview(View view)
    {
        choose_recyclerview = (RecyclerView) view.findViewById(R.id.choose_recyclerview);

        scheduleButton = (Button) view.findViewById(R.id.scheduleButton);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        choose_recyclerview.setLayoutManager(gridLayoutManager);

        chooseDateAdapter = new ChooseDateAdapter(getActivity(), choosedateData);

        choose_recyclerview.setAdapter(chooseDateAdapter);

        choose_recyclerview.setNestedScrollingEnabled(false);

        scheduleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                ConfirmOrderFragment confirmOrderFragment = new ConfirmOrderFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, confirmOrderFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

            }
        });

    }

    private void setServicesData()
    {

        try {
            choosedateData.clear();
        } catch (Exception ex) {
        }
        choosedateData.add(new ChooseDateData("","","09:00"));
        choosedateData.add(new ChooseDateData("", "", "09:15"));
        choosedateData.add(new ChooseDateData("", "", "09:30"));
        choosedateData.add(new ChooseDateData("", "", "09:45"));
        choosedateData.add(new ChooseDateData("","","10:00"));
        choosedateData.add(new ChooseDateData("", "", "10:15"));
        choosedateData.add(new ChooseDateData("", "", "10:30"));
        choosedateData.add(new ChooseDateData("", "", "10:45"));
        choosedateData.add(new ChooseDateData("","","11:00"));
        choosedateData.add(new ChooseDateData("", "", "11:15"));
        choosedateData.add(new ChooseDateData("", "", "11:30"));
        choosedateData.add(new ChooseDateData("", "", "11:45"));

    }



}
