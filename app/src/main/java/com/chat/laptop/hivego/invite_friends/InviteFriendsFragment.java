package com.chat.laptop.hivego.invite_friends;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.dashboard.fragment.GenderFragment;


public class InviteFriendsFragment extends Fragment implements View.OnClickListener
{



    TextView toolbar_title_txt;
    Button post_invite_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invite_friends, container, false);

        setuptoolbar();

        setup_layout(view);
        return  view;
    }

    private void setup_layout(View view)
    {
        post_invite_button = (Button) view.findViewById(R.id.post_invite_button);

        post_invite_button.setOnClickListener(this);

    }


    private void setuptoolbar()
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("INVITE FRIENDS");

    }


    public  void onClick(View v)
    {

        switch (v.getId())
        {

            case R.id.post_invite_button:
                PastInviteFragment pastInviteFragment = new PastInviteFragment();
                android.support.v4.app.FragmentTransaction message_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                message_fragmentTransaction.replace(R.id.frame, pastInviteFragment);
                message_fragmentTransaction.addToBackStack(null);
                message_fragmentTransaction.commit();


                break;

        }


    }


}
