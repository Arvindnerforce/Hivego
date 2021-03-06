package com.chat.laptop.hivego.choose_trending_looks.choose_style;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.salon.SalonListAdapter;
import com.chat.laptop.hivego.salon.SalonListData;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;


public class ChooseStyleFragment extends Fragment
{

    TextView toolbar_title_txt;
    RecyclerView salonlist_recyclerview;
    StyleListAdapter styleListAdapter;
    public static ArrayList<StyleList> styleLists = new ArrayList<StyleList>();
    ArrayList<Integer> itemsimg = new ArrayList<Integer>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_style, container, false);

        setFilterData();

        setup_recyclerview(view);

        setuptoolbar(view);

        setup_font(view);

        return view;
    }

    private void setup_recyclerview(View view)
    {

        salonlist_recyclerview = (RecyclerView) view.findViewById(R.id.salon_recyclerview);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        salonlist_recyclerview.setLayoutManager(mLayoutManager);


        salonlist_recyclerview.setLayoutManager(mLayoutManager);

        styleListAdapter = new StyleListAdapter(getActivity(), styleLists);

        salonlist_recyclerview.setAdapter(styleListAdapter);


    }

    private void setFilterData()
    {


        try {
            styleLists.clear();
        } catch (Exception ex) {
        }
        styleLists.add(new StyleList(R.drawable.ic_style1,"","HAIR CARE"));
        styleLists.add(new StyleList(R.drawable.ic_style2, "", "FACE"));
        styleLists.add(new StyleList(R.drawable.ic_style1, "", "MAKEUP"));
        styleLists.add(new StyleList(R.drawable.ic_style2, "", "NAIL"));
        styleLists.add(new StyleList(R.drawable.ic_style1, "", "BODY"));
        styleLists.add(new StyleList(R.drawable.ic_style2, "", "MASSAGE AND SPA"));
        styleLists.add(new StyleList(R.drawable.ic_style1, "", "EXCLUSIVE OFFERS"));


    }


    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("CHOOSE A STYLE");

    }

    private void setup_font(View view)
    {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }



}
