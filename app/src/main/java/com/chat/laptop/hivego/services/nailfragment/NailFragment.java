package com.chat.laptop.hivego.services.nailfragment;

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
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.date_time_fragment.DateTimeFragment;
import com.chat.laptop.hivego.salon.NearestSalonFragment;
import com.chat.laptop.hivego.services.MenServicesAdapter;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;


public class NailFragment extends Fragment
{

    RecyclerView nail_recyclerview;
    TextView toolbar_title_txt;
    NailAdapter nailAdapter;
    Button search_button;
    public static ArrayList<NailData> nailServicesData = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nail, container, false);
        setuptoolbar(view);
        setServicesData();
        setup_recyclerview(view);
        setup_font(view);

        return view;
    }

    private void setup_recyclerview(View view)
    {

        nail_recyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);
        search_button = (Button) view.findViewById(R.id.continueButton);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        nail_recyclerview.setLayoutManager(mLayoutManager);

        nailAdapter = new NailAdapter(getActivity(), nailServicesData);

        nail_recyclerview.setAdapter(nailAdapter);


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DateTimeFragment nearestSalonActivity = new DateTimeFragment();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, nearestSalonActivity);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();


            }
        });



    }

    private void setServicesData()
    {
        try {
            nailServicesData.clear();
        } catch (Exception ex) {
        }

        ArrayList<ServiceDetailData> selleranswerdatas = new ArrayList<ServiceDetailData>();
        selleranswerdatas.add(new ServiceDetailData("face", "", "Regular Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Crystal Spa Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Anti Tan Manicure"));
        nailServicesData.add(new NailData(selleranswerdatas, "MANICURE"));


        selleranswerdatas = new ArrayList<ServiceDetailData>();
        selleranswerdatas.add(new ServiceDetailData("face", "", "Regular Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Crystal Spa Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Anti Tan Manicure"));
        nailServicesData.add(new NailData(selleranswerdatas, "PEDICURE"));

        selleranswerdatas = new ArrayList<ServiceDetailData>();
        selleranswerdatas.add(new ServiceDetailData("face", "", "Regular Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Crystal Spa Manicure"));
        selleranswerdatas.add(new ServiceDetailData("face", "", "Anti Tan Manicure"));
        nailServicesData.add(new NailData(selleranswerdatas, "PEDICURE"));


    }

    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("NAIL");

    }

    private void setup_font(View view) {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }



}
