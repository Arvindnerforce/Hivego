package com.chat.laptop.hivego.chat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.blog.BlogAdapter;
import com.chat.laptop.hivego.blog.BlogData;

import java.util.ArrayList;


public class ChatWithusFragment extends Fragment implements View.OnClickListener
{


    TextView toolbar_title_txt;
    Button continueButton;
    RelativeLayout chat_layout;
    RecyclerView chat_recyclerview;
    public static ArrayList<ChatWithusData> chatWithusDatas = new ArrayList<>();
    ChatWithusAdapter chatWithusAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_withus, container, false);

        setuptoolbar();

        setup_data();

        setup_layout(view);

        setup_recyclerview(view);

        return view;


    }

    private void setup_recyclerview(View view)
    {

        chat_recyclerview = (RecyclerView) view.findViewById(R.id.chat_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        chat_recyclerview.setLayoutManager(mLayoutManager);

        chatWithusAdapter = new ChatWithusAdapter(getActivity(), chatWithusDatas);
        chat_recyclerview.setAdapter(chatWithusAdapter);

    }

    private void setup_layout(View view)
    {
        chat_layout = (RelativeLayout) view.findViewById(R.id.chat_layout);
        chat_recyclerview = (RecyclerView) view.findViewById(R.id.chat_recyclerview);
        continueButton = (Button) view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
    }


    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);
        toolbar_title_txt.setText("CHAT WITH US");

    }


    private void setup_data()
    {
        try {
            chatWithusDatas.clear();
        } catch (Exception ex) {
        }
        chatWithusDatas.add(new ChatWithusData(R.drawable.hair_care,"","HAIR CARE"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.face, "", "FACE"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.hair_care, "", "MAKEUP"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.face, "", "NAIL"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.hair_care, "", "BODY"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.face, "", "MASSAGE AND SPA"));
        chatWithusDatas.add(new ChatWithusData(R.drawable.hair_care, "", "EXCLUSIVE OFFERS"));
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
