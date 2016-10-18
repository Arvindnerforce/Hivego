package com.chat.laptop.hivego.dashboard.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chat.laptop.hivego.R;


public class GenderFragment extends Fragment {

    ImageButton imageButton;
    ImageView check_male_image,check_female_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view= inflater.inflate(R.layout.fragment_gender, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.men_image);

        check_male_image = (ImageView) view.findViewById(R.id.check_male_image);

        imageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (view.isSelected()){
                    check_male_image.setVisibility(View.VISIBLE);
                    view.setSelected(false);
                }
                else
                {
                    check_male_image.setVisibility(View.INVISIBLE);
                    imageButton.setSelected(false);
                    //put all the other buttons you might want to disable here...
                    view.setSelected(true);
                }
            }
        });

        return view;
    }

}
