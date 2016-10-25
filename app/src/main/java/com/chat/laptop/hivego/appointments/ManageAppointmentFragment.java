package com.chat.laptop.hivego.appointments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.confirm_fragment.ConfirmOrderAdapter;
import com.chat.laptop.hivego.confirm_fragment.ConfirmOrderData;

import java.util.ArrayList;


public class ManageAppointmentFragment extends Fragment
{

    public static ArrayList<ManageAppointmentData> manageAppointmentData = new ArrayList<>();
    RecyclerView  manage_appointment_recyclerview;
    ManageAppointmentAdapter manageAppointmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage_appointment, container, false);

        setServicesData();

        setup_recyclerview(view);

        return view;
    }


    private void setServicesData()
    {
        try
        {
            manageAppointmentData.clear();
        }
        catch (Exception ex) {
        }
        manageAppointmentData.add(new ManageAppointmentData("hair_care","","HAIR CARE"));
        manageAppointmentData.add(new ManageAppointmentData("face", "", "FACE"));
        manageAppointmentData.add(new ManageAppointmentData("mackup", "", "MAKEUP"));

    }


    private void setup_recyclerview(View view)
    {
        manage_appointment_recyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        manage_appointment_recyclerview.setLayoutManager(mLayoutManager);

        manageAppointmentAdapter = new ManageAppointmentAdapter(getActivity(), manageAppointmentData);

        manage_appointment_recyclerview.setAdapter(manageAppointmentAdapter);

        manage_appointment_recyclerview.setNestedScrollingEnabled(true);
    }


}
