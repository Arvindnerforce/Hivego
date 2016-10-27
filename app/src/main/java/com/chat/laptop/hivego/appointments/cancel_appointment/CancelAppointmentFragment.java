package com.chat.laptop.hivego.appointments.cancel_appointment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chat.laptop.hivego.R;


public class CancelAppointmentFragment extends Fragment
{

    TextView toolbar_title_txt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_cancel_appointment, container, false);

        setuptoolbar(view);

        return view;


    }


    private void setuptoolbar(View view)
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("CANCEL APPOINTMENT");

    }

}
