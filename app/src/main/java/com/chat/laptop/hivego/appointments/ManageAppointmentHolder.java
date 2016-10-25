package com.chat.laptop.hivego.appointments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/25/2016.
 */
public class ManageAppointmentHolder extends RecyclerView.ViewHolder {

    View view;
    TextView salon_name;
    ImageView men_image;
    RelativeLayout relativeLayout;

    public ManageAppointmentHolder(View itemView) {
        super(itemView);

        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.serviceLayout);

        salon_name = (TextView) itemView.findViewById(R.id.salon_name);

        men_image = (ImageView) itemView.findViewById(R.id.men_image);

        view = itemView;
    }
}

