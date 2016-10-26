package com.chat.laptop.hivego.choose_trending_looks.choose_style;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;

/**
 * Created by John on 10/26/2016.
 */
public class StyleHolder extends RecyclerView.ViewHolder

{
    View view;

    ImageView check_style_image,style_image;

    RelativeLayout salon_list_item ;

    public StyleHolder(View itemView)
    {
        super(itemView);

        salon_list_item = (RelativeLayout) itemView.findViewById(R.id.salon_list_item);

        check_style_image = (ImageView) itemView.findViewById(R.id.check_style_image);

        style_image =(ImageView) itemView.findViewById(R.id.style_image);

        view = itemView;
    }
}
