package com.chat.laptop.hivego.appointments.my_appointment;

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

import java.util.ArrayList;


public class MyAppointmentFragment extends Fragment {


    public static ArrayList<CompleteAppointmentData> complete_appointmentDatas = new ArrayList<>();

    public static ArrayList<Upcoming_AppointData> upcoming_appointmentDatas = new ArrayList<>();
    RecyclerView upcoming_recyclerview,complete_appointment_recyclerview;
    UpcomingAppointmentAdapter upcomingAppointmentAdapter;
    CompleteAppointmentAdapter completeAppointmentAdapter;
    TextView toolbar_title_txt;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_appointment, container, false);

        setup_tolbar();
        setUpcommingAppointmentData();
        setCompleteAppointmentData();
        setup_complete_appointment(view);
        setup_recyclerview(view);


        return view;
    }

    private void setup_complete_appointment(View view) {


        complete_appointment_recyclerview = (RecyclerView) view.findViewById(R.id.complete_appointment);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        complete_appointment_recyclerview.setLayoutManager(mLayoutManager);

        completeAppointmentAdapter = new CompleteAppointmentAdapter(getActivity(), complete_appointmentDatas);

        complete_appointment_recyclerview.setAdapter(completeAppointmentAdapter);

        complete_appointment_recyclerview.setNestedScrollingEnabled(true);
    }

    private void setCompleteAppointmentData() {

        try
        {
            complete_appointmentDatas.clear();
        } catch (Exception ex) {
        }

        complete_appointmentDatas.add(new CompleteAppointmentData("face", "", "Regular Manicure"));
        complete_appointmentDatas.add(new CompleteAppointmentData("face", "", "Crystal Spa Manicure"));

    }

    private void setup_tolbar()
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);
        toolbar_title_txt.setText("MY APPOINTMENT");

    }

    private void setUpcommingAppointmentData()
    {

        try
        {
            upcoming_appointmentDatas.clear();
        } catch (Exception ex) {
        }

        upcoming_appointmentDatas.add(new Upcoming_AppointData("face", "", "Regular Manicure"));
        upcoming_appointmentDatas.add(new Upcoming_AppointData("face", "", "Crystal Spa Manicure"));

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
