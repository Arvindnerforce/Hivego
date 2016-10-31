package com.chat.laptop.hivego.appointments.my_appointment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/28/2016.
 */
public class CompleteAppointmentHolder extends RecyclerView.ViewHolder {

        View view;
        TextView date_txt;
        RelativeLayout my_aapointment_layout;


         public CompleteAppointmentHolder(View itemView)
        {
        super(itemView);

        my_aapointment_layout = (RelativeLayout) itemView.findViewById(R.id.my_aapointment_layout);

        date_txt = (TextView) itemView.findViewById(R.id.date_txt);

        view = itemView;
        }
        }