package com.chat.laptop.hivego.thankyou;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chat.laptop.hivego.R;


public class ThankyouFragment extends Fragment implements View.OnClickListener {

     Button seeDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thankyou, container, false);
        setup_layout(view);
        return view;
    }

    private void setup_layout(View view) {

        seeDetails = (Button)view.findViewById(R.id.seeDetail_button);

        seeDetails.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.seeDetail_button:

        }
    }
}
