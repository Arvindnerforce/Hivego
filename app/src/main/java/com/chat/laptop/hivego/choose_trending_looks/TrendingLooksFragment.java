package com.chat.laptop.hivego.choose_trending_looks;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
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
import com.chat.laptop.hivego.choose_trending_looks.bread.BeardFragment;
import com.chat.laptop.hivego.choose_trending_looks.choose_style.ChooseStyleFragment;
import com.chat.laptop.hivego.choose_trending_looks.choose_style.StyleList;


public class TrendingLooksFragment extends Fragment
{

    Button continueButton;
    TextView toolbar_title_txt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_trending_looks, container, false);

        setuptoolbar(view);

        continueButton  =(Button) view.findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ChooseStyleFragment chooseStyleFragment = new ChooseStyleFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, chooseStyleFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();
            }
        });

        return view;
    }
    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar.setVisibility(View.GONE);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

       // toolbar_title_txt.setText("CHOOSE A STYLE");

    }



}
