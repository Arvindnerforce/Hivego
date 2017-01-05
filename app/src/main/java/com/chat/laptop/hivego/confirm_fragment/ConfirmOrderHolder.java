package com.chat.laptop.hivego.confirm_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/24/2016.
 */
public class ConfirmOrderHolder extends RecyclerView.ViewHolder {

    View view;
    TextView textView_services_value,textView_service_name,textView_service_total_price;
    Button decreament_Service,increament_Service;
    RelativeLayout relativeLayout;

    public ConfirmOrderHolder(View itemView)
    {
        super(itemView);

        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.serviceLayout);

        textView_services_value = (TextView) itemView.findViewById(R.id.textView_services_value);

        increament_Service = (Button) itemView.findViewById(R.id.increament_Service);

        decreament_Service = (Button) itemView.findViewById(R.id.decreament_Service);

        textView_service_name = (TextView) itemView.findViewById(R.id.textView_service_name);

        textView_service_total_price = (TextView) itemView.findViewById(R.id.textView_service_total_price);

        view = itemView;
    }
}
