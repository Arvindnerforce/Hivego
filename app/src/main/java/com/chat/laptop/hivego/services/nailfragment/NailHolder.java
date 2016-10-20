package com.chat.laptop.hivego.services.nailfragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/20/2016.
 */
public class NailHolder extends RecyclerView.ViewHolder {

    View view;
    TextView service_tittle;

    LinearLayout nail_linearlayout;
    RecyclerView recyclerView;

    public NailHolder(View itemView) {

        super(itemView);

        nail_linearlayout = (LinearLayout) itemView.findViewById(R.id.nail_linearlayout);

        service_tittle = (TextView) itemView.findViewById(R.id.service_tittle);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.service_detail_recyclerview);

        view = itemView;
    }
}