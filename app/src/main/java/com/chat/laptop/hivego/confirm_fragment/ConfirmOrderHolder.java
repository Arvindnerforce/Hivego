package com.chat.laptop.hivego.confirm_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/24/2016.
 */
public class ConfirmOrderHolder extends RecyclerView.ViewHolder {

    View view;
    TextView salon_name;
    ImageView men_image;
    RelativeLayout relativeLayout;

    public ConfirmOrderHolder(View itemView) {
        super(itemView);

        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.serviceLayout);

        salon_name = (TextView) itemView.findViewById(R.id.salon_name);

        men_image = (ImageView) itemView.findViewById(R.id.men_image);

        view = itemView;
    }
}
