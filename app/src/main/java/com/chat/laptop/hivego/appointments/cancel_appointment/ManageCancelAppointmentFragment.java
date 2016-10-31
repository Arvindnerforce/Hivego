package com.chat.laptop.hivego.appointments.cancel_appointment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chat.laptop.hivego.R;


public class ManageCancelAppointmentFragment extends Fragment
{

    TextView toolbar_title_txt;
    ImageView complete_or_cancel_image;
    String appointment_detail;
    TextView refund_text;
    Button sendRecieptButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_manage_cancel_appointment, container, false);

        Bundle bundle = this.getArguments();
        appointment_detail = bundle.getString("complete_appointment");

         setuptoolbar();
         setup_layout(view);
        return view;
    }

    private void setup_layout(View view)
    {

        complete_or_cancel_image = (ImageView) view.findViewById(R.id.complete_or_cancel_image);
        refund_text = (TextView) view.findViewById(R.id.refind_description);
        sendRecieptButton = (Button) view.findViewById(R.id.sendRecieptButton);

        if(appointment_detail.equals("Complete"))
        {

            complete_or_cancel_image.setImageResource(R.drawable.ic_completed);
            refund_text.setVisibility(View.GONE);
            sendRecieptButton.setVisibility(View.VISIBLE);


        }
        else
        {

            complete_or_cancel_image.setImageResource(R.drawable.ic_cancellation);
            refund_text.setVisibility(View.VISIBLE);
            sendRecieptButton.setVisibility(View.GONE);
        }


    }


    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("MANAGE APPOINTMENTS");
    }


}
