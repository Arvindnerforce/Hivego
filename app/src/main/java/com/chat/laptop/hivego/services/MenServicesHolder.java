package com.chat.laptop.hivego.services;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/17/2016.
 */
public class MenServicesHolder extends RecyclerView.ViewHolder {

    View view;
    TextView salon_name;
    ImageView men_image;

    public MenServicesHolder(View itemView) {
        super(itemView);

        salon_name = (TextView) itemView.findViewById(R.id.salon_name);

        men_image = (ImageView) itemView.findViewById(R.id.men_image);

        view = itemView;
    }
}