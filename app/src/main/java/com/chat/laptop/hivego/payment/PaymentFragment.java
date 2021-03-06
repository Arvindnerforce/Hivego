package com.chat.laptop.hivego.payment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.AppointmentDetailsFragment;
import com.chat.laptop.hivego.thankyou.ThankyouFragment;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;


public class PaymentFragment extends Fragment implements View.OnClickListener
{

    Button payButton;
    TextView toolbar_title_txt;
    MaterialFavoriteButton payonline_material_button,payment_salon_material_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        setuptoolbar();

        setupLayout(view);

        return view;
    }

    private void setupLayout(View view)
    {

        payButton = (Button) view.findViewById(R.id.payButton);

        payonline_material_button = (MaterialFavoriteButton) view.findViewById(R.id.payonline_material_button);

        payment_salon_material_button = (MaterialFavoriteButton) view.findViewById(R.id.payment_salon_material_button);

        payButton.setOnClickListener(this);


        payonline_material_button.setOnFavoriteChangeListener(
                        new MaterialFavoriteButton.OnFavoriteChangeListener()
                        {
                            @Override
                            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite)
                            {

                                System.out.println("payment option ===========" + favorite);
                                if (favorite == true)
                                {

                                    payment_salon_material_button.setFavorite(false);
                                }

                            }
                        });

        payment_salon_material_button.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite)
                    {

                        System.out.println("payment option ==========="+ favorite);
                        if(favorite== true){

                            payonline_material_button.setFavorite(false);
                        }

                    }
                });

    }


    private void setuptoolbar()
    {


        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setVisibility(View.VISIBLE);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("PAYMENT OPTIONS");

    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {

            case R.id.payButton:

                ThankyouFragment thankyouFragment = new ThankyouFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, thankyouFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

                break;

        }
    }
}
