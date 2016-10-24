package com.chat.laptop.hivego.date_time_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/24/2016.
 */
public class ChooseDateHolder extends RecyclerView.ViewHolder {

    View view;
    TextView time_name;

    RelativeLayout relativeLayout;

    public ChooseDateHolder(View itemView) {
        super(itemView);

        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.serviceLayout);

        time_name = (TextView) itemView.findViewById(R.id.time_name);


        view = itemView;
    }
}