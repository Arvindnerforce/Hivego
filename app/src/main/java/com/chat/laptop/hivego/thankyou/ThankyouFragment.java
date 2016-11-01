package com.chat.laptop.hivego.thankyou;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.AppointmentDetailsFragment;


public class ThankyouFragment extends Fragment implements View.OnClickListener {

     Button seeDetails;
    TextView toolbar_title_txt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thankyou, container, false);

        setuptoolbar();

        setup_layout(view);
        return view;
    }

    private void setuptoolbar() {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setVisibility(View.VISIBLE);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("THANK YOU");


    }


    private void setup_layout(View view) {

        seeDetails = (Button)view.findViewById(R.id.seeDetail_button);

        seeDetails.setOnClickListener(this);


    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.seeDetail_button:

                AppointmentDetailsFragment appointmentDetailsFragment = new AppointmentDetailsFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, appointmentDetailsFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

                break;
        }
    }
}
