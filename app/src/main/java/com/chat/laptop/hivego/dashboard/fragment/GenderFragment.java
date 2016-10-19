package com.chat.laptop.hivego.dashboard.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chat.laptop.hivego.R;


public class GenderFragment extends Fragment {

    ImageButton menButton,womanButton;
    ImageView check_male_image,check_female_image;
    int isClicked =  0,womanisClicked = 0;
    MaterialDialog  dailog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        View view= inflater.inflate(R.layout.fragment_gender, container, false);

        menButton = (ImageButton) view.findViewById(R.id.men_image);

        womanButton = (ImageButton) view.findViewById(R.id.women_image);

        check_male_image = (ImageView) view.findViewById(R.id.check_male_image);

        check_female_image = (ImageView) view.findViewById(R.id.check_female_image);

        menButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (isClicked == 0) {
                    check_male_image.setVisibility(View.VISIBLE);
                    showDialog();
                    isClicked = 1;
                }
                else
                {
                    check_male_image.setVisibility(View.INVISIBLE);
                    isClicked = 0;
                }


            }
        });

        womanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (womanisClicked == 0) {
                    check_female_image.setVisibility(View.VISIBLE);
                    womanisClicked = 1;
                }
                else
                {
                    check_female_image.setVisibility(View.INVISIBLE);
                    womanisClicked = 0;
                }

            }
        });

        return view;
    }


    private void showPopUp()
    {

        dailog = new MaterialDialog.Builder(getActivity())
                .backgroundColor(Color.parseColor("#ECEBEB"))
                .title("Hivego Would Like to Send You Notifications")
                .customView(R.layout.custom_dialog, true).build();

        Button b = (Button) dailog.findViewById(R.id.submit);

        Button cancel = (Button) dailog.findViewById(R.id.cancel);
        // TextView textView = (TextView) dailog.findViewById(R.id.textView1);

        //   mExplosionField.explode(icon,null,0,5000);
        //addListener(dailog.findViewById(R.id.root));

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                dailog.dismiss();

            }
        });


        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                dailog.dismiss();
            }
        });



        dailog.show();


    }


        public void showDialog( )
        {
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_dialog);

            TextView text = (TextView) dialog.findViewById(R.id.character);
           // text.setText(msg);

            Button dialogButton = (Button) dialog.findViewById(R.id.cancel);

            Button ok = (Button) dialog.findViewById(R.id.submit);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    dialog.dismiss();
                    SearchCityFragment searchCityFragment = new SearchCityFragment();
                    android.support.v4.app.FragmentTransaction search_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    search_fragmentTransaction.replace(R.id.frame, searchCityFragment);
                    search_fragmentTransaction.addToBackStack(null);
                    search_fragmentTransaction.commit();


                }
            });

            dialog.show();

        }



}
