package com.chat.laptop.hivego.salon;

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
import com.chat.laptop.hivego.services.MenServicesAdapter;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;

public class SalonListFragment extends Fragment {


    TextView toolbar_title_txt;
    RecyclerView salonlist_recyclerview;
    SalonListAdapter salonListAdapter;
    public static ArrayList<SalonListData> salonListDatas = new ArrayList<SalonListData>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salon_list, container, false);

        setFilterData();
        setup_recyclerview(view);
        setup_font();

        return view;
    }

    private void setup_recyclerview(View view)
    {

        salonlist_recyclerview = (RecyclerView) view.findViewById(R.id.salon_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        salonlist_recyclerview.setLayoutManager(mLayoutManager);

        salonListAdapter = new SalonListAdapter(getActivity(), salonListDatas);

        salonlist_recyclerview.setAdapter(salonListAdapter);
    }

    private void setFilterData()
    {

        try {
            salonListDatas.clear();
        } catch (Exception ex) {
        }
        salonListDatas.add(new SalonListData("hair_care","","Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("face", "", "Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("mackup", "", "Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("nail", "", "Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("body", "", "Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("massage_spa", "", "Havigo F Salon Paris, Greater Kailash - II"));
        salonListDatas.add(new SalonListData("exclusive_offer", "", "Havigo F Salon Paris, Greater Kailash - II"));



    }

    private void setup_font() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        //toolbar_title_txt.setTypeface(tf);
    }

}
