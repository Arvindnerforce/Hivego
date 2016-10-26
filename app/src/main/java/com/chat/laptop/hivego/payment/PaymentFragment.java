package com.chat.laptop.hivego.payment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.AppointmentDetailsFragment;


public class PaymentFragment extends Fragment implements View.OnClickListener{

    Button payButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        setupLayout(view);

        return view;
    }

    private void setupLayout(View view)
    {

        payButton = (Button) view.findViewById(R.id.payButton);

        payButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {

            case R.id.payButton:

                AppointmentDetailsFragment manageAppointmentFragment = new AppointmentDetailsFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, manageAppointmentFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

                break;

        }
    }
}
