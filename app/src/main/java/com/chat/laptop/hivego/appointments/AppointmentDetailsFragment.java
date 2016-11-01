package com.chat.laptop.hivego.appointments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.cancel_appointment.CancelAppointmentFragment;
import com.chat.laptop.hivego.appointments.cancel_appointment.ManageCancelAppointmentFragment;
import com.chat.laptop.hivego.appointments.my_appointment.MyAppointmentFragment;
import com.chat.laptop.hivego.choose_trending_looks.TrendingLooksFragment;
import com.chat.laptop.hivego.choose_trending_looks.choose_style.ChooseStyleFragment;
import com.chat.laptop.hivego.date_time_fragment.DateTimeFragment;

import java.util.ArrayList;


public class AppointmentDetailsFragment extends Fragment implements View.OnClickListener
{

    public static ArrayList<AppointmentDetailsData> manageAppointmentData = new ArrayList<>();
    RecyclerView  manage_appointment_recyclerview;
    AppointmentDetailsAdapter manageAppointmentAdapter;
    Button trendingButton,callusButton,navigateButton,cancelButton,scheduleButton;
    TextView toolbar_title_txt,title_txt,prepaid_txt,salon_heading,salon_name,salon_address,customer_name_heading,booking_name_heading
            ,sex_name_heading,time_name_heading,customer_name_txt,booking_id_txt,sex_txt,user_time_txt,date_heading,date_txt,time_txt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment_details, container, false);

        setServicesData();

        setuptoolbar(view);

        setup_layout(view);

        setup_font(view);

        setup_recyclerview(view);

        return view;
    }



    private void setup_layout(View view)
    {
        scheduleButton = (Button) view.findViewById(R.id.rescheduleButton);

        scheduleButton.setOnClickListener(this);

        cancelButton = (Button) view.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(this);

        trendingButton = (Button) view.findViewById(R.id.trendingButton);

        trendingButton.setOnClickListener(this);

        callusButton = (Button) view.findViewById(R.id.callusButton);

        callusButton.setOnClickListener(this);

        navigateButton = (Button) view.findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(this);

        title_txt = (TextView) view.findViewById(R.id.title_txt);
        prepaid_txt = (TextView) view.findViewById(R.id.prepaid_txt);
        salon_heading = (TextView) view.findViewById(R.id.salon_heading);
        salon_name = (TextView) view.findViewById(R.id.salon_name);
        salon_address = (TextView) view.findViewById(R.id.salon_address);
        customer_name_heading = (TextView) view.findViewById(R.id.customer_name_heading);
        booking_name_heading = (TextView) view.findViewById(R.id.booking_name_heading);
        sex_name_heading = (TextView) view.findViewById(R.id.sex_name_heading);
        time_name_heading = (TextView) view.findViewById(R.id.time_name_heading);
        customer_name_txt = (TextView) view.findViewById(R.id.customer_name_txt);
        booking_id_txt = (TextView) view.findViewById(R.id.booking_id_txt);
        user_time_txt = (TextView) view.findViewById(R.id.user_time_txt);
        date_heading = (TextView) view.findViewById(R.id.date_heading);
        date_txt = (TextView) view.findViewById(R.id.date_txt);
        time_txt = (TextView) view.findViewById(R.id.time_txt);
        sex_txt = (TextView) view.findViewById(R.id.sex_txt);
        sex_txt = (TextView) view.findViewById(R.id.sex_txt);

    }

    private void setServicesData()
    {
        try
        {
            manageAppointmentData.clear();
        }
        catch (Exception ex) {
        }
        manageAppointmentData.add(new AppointmentDetailsData("hair_care","","HAIR CARE"));
        manageAppointmentData.add(new AppointmentDetailsData("face", "", "FACE"));
        manageAppointmentData.add(new AppointmentDetailsData("mackup", "", "MAKEUP"));

    }


    private void setup_recyclerview(View view)
    {
        manage_appointment_recyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        manage_appointment_recyclerview.setLayoutManager(mLayoutManager);

        manageAppointmentAdapter = new AppointmentDetailsAdapter(getActivity(), manageAppointmentData);

        manage_appointment_recyclerview.setAdapter(manageAppointmentAdapter);

        manage_appointment_recyclerview.setNestedScrollingEnabled(true);
    }


    private void setuptoolbar(View view)
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("APPOINTMENT DETAILS");

    }

    private void setup_font(View view)
    {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }


    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.trendingButton:

                TrendingLooksFragment chooseStyleFragment = new TrendingLooksFragment();
                FragmentManager fragmentManager = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, chooseStyleFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

                break;


            case R.id.cancelButton:
                CancelAppointmentFragment cancelAppointmentFragment = new CancelAppointmentFragment();
                FragmentManager fragmentManager2 = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction2 = fragmentManager2.beginTransaction();
                search_fragmentTransaction2.replace(R.id.frame, cancelAppointmentFragment);
                search_fragmentTransaction2.addToBackStack(null);
                search_fragmentTransaction2.commit();
                break;

            case R.id.rescheduleButton:
                DateTimeFragment dateTimeFragment = new DateTimeFragment();
                FragmentManager datetime_fragment = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction date_time_fragmentTransaction = datetime_fragment.beginTransaction();
                date_time_fragmentTransaction.replace(R.id.frame, dateTimeFragment);
                date_time_fragmentTransaction.addToBackStack(null);
                date_time_fragmentTransaction.commit();
                break;

        }
    }
}
