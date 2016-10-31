package com.chat.laptop.hivego.chat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;


public class ChatWithusFragment extends Fragment implements View.OnClickListener
{


    TextView toolbar_title_txt;
    Button continueButton;
    RelativeLayout chat_layout;
    RecyclerView chat_recyclerview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_withus, container, false);

        setuptoolbar();

        setup_layout(view);

        return view;






    }

    private void setup_layout(View view) {

        chat_layout = (RelativeLayout) view.findViewById(R.id.chat_layout);

        chat_recyclerview = (RecyclerView) view.findViewById(R.id.chat_recyclerview);

        continueButton = (Button) view.findViewById(R.id.continueButton);

        continueButton.setOnClickListener(this);

    }


    private void setuptoolbar()
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("INVITE FRIENDS");

    }

    public void onClick(View v)
    {

        switch (v.getId())
        {

            case R.id.continueButton:
                chat_layout.setVisibility(View.GONE);
                chat_recyclerview.setVisibility(View.VISIBLE);

                break;
        }
    }

}
