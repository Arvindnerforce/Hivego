package com.chat.laptop.hivego.services.nailfragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

/**
 * Created by John on 10/20/2016.
 */
public class ServiceDetailHolder extends RecyclerView.ViewHolder {

    View view;
    TextView salon_name;

    LinearLayout linear_ayout;

    MaterialFavoriteButton materialFavoriteButton;

    public ServiceDetailHolder(View itemView) {
        super(itemView);

        linear_ayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);

        salon_name = (TextView) itemView.findViewById(R.id.service_name);

        materialFavoriteButton = (MaterialFavoriteButton) itemView.findViewById(R.id.material_button);

        view = itemView;
    }
}