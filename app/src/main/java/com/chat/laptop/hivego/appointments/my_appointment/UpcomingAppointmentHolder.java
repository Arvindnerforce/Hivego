package com.chat.laptop.hivego.appointments.my_appointment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/27/2016.
 */
public class UpcomingAppointmentHolder  extends RecyclerView.ViewHolder {

    View view;
    TextView service_tittle;
    LinearLayout nail_linearlayout;
    RecyclerView recyclerView;

    public UpcomingAppointmentHolder(View itemView)
    {
        super(itemView);

        nail_linearlayout = (LinearLayout) itemView.findViewById(R.id.nail_linearlayout);

        service_tittle = (TextView) itemView.findViewById(R.id.service_tittle);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.service_detail_recyclerview);

        view = itemView;
    }
}