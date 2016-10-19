package com.chat.laptop.hivego.salon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/19/2016.
 */
public class SalonListHolder extends RecyclerView.ViewHolder {
    View view;
    TextView salon_name;
    ImageView men_image;
    Button button;
    RelativeLayout salon_list_item ;

    public SalonListHolder(View itemView) {
        super(itemView);

        salon_list_item = (RelativeLayout) itemView.findViewById(R.id.salon_list_item);

        salon_name = (TextView) itemView.findViewById(R.id.salon_name);

        men_image = (ImageView) itemView.findViewById(R.id.men_image);
        button = (Button) itemView.findViewById(R.id.flagButton);

        view = itemView;
    }
}
