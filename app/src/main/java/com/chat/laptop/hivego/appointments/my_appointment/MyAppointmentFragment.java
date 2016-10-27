package com.chat.laptop.hivego.appointments.my_appointment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.date_time_fragment.DateTimeFragment;
import com.chat.laptop.hivego.services.nailfragment.NailAdapter;
import com.chat.laptop.hivego.services.nailfragment.NailData;
import com.chat.laptop.hivego.services.nailfragment.ServiceDetailData;

import java.util.ArrayList;


public class MyAppointmentFragment extends Fragment {


    public static ArrayList<upcoming_appointmentData> upcoming_appointmentDatas = new ArrayList<>();
    RecyclerView upcoming_recyclerview;
    UpcomingAppointmentAdapter upcomingAppointmentAdapter;

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_appointment, container, false);

        setServicesData();
        setup_recyclerview(view);

        return view;
    }

    private void setServicesData()
    {

        try
        {
            upcoming_appointmentDatas.clear();
        } catch (Exception ex) {
        }

        upcoming_appointmentDatas.add(new upcoming_appointmentData("face", "", "Regular Manicure"));
        upcoming_appointmentDatas.add(new upcoming_appointmentData("face", "", "Crystal Spa Manicure"));

    }



    private void setup_recyclerview(View view)
    {

        upcoming_recyclerview = (RecyclerView) view.findViewById(R.id.upcoming_appointment);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        upcoming_recyclerview.setLayoutManager(mLayoutManager);

        upcomingAppointmentAdapter = new UpcomingAppointmentAdapter(getActivity(), upcoming_appointmentDatas);

        upcoming_recyclerview.setAdapter(upcomingAppointmentAdapter);

        upcoming_recyclerview.setNestedScrollingEnabled(true);

    }

}
