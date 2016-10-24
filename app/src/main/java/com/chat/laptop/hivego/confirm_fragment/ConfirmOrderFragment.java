package com.chat.laptop.hivego.confirm_fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class ConfirmOrderFragment extends Fragment
{


    TextView toolbar_title_txt;
    RecyclerView confirm_recyclerview;
    ConfirmOrderAdapter confirmServicesAdapter;
    public static ArrayList<ConfirmOrderData> confirmOrderDatas = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_order, container, false);

        setuptoolbar(view);
        setServicesData();
        setup_recyclerview(view);
        setup_font(view);

        return view;
    }

    private void setup_recyclerview(View view)
    {
        confirm_recyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        confirm_recyclerview.setLayoutManager(mLayoutManager);

        confirmServicesAdapter = new ConfirmOrderAdapter(getActivity(), confirmOrderDatas);

        confirm_recyclerview.setAdapter(confirmServicesAdapter);

        confirm_recyclerview.setNestedScrollingEnabled(true);


    }


    private void setServicesData()
    {

        try {
            confirmOrderDatas.clear();
        } catch (Exception ex) {
        }
        confirmOrderDatas.add(new ConfirmOrderData("hair_care","","HAIR CARE"));
        confirmOrderDatas.add(new ConfirmOrderData("face", "", "FACE"));
        confirmOrderDatas.add(new ConfirmOrderData("mackup", "", "MAKEUP"));

    }

    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("CONFIRM");

    }

    private void setup_font(View view) {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }


}
