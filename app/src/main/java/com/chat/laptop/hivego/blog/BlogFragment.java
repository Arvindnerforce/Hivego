package com.chat.laptop.hivego.blog;

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
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.services.MenServicesAdapter;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;


public class BlogFragment extends Fragment
{
    TextView toolbar_title_txt;
    public static ArrayList<BlogData> blogDatas = new ArrayList<>();
    RecyclerView blog_recyclerview;
    BlogAdapter blogAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blog, container, false);
        setuptoolbar();
        setup_data();
        setup_recyclerview(view);

        return view;
    }

    private void setup_data()
    {

            try {
                blogDatas.clear();
            } catch (Exception ex) {
            }
        blogDatas.add(new BlogData(R.drawable.hair_care,"","HAIR CARE"));
        blogDatas.add(new BlogData(R.drawable.face, "", "FACE"));
        blogDatas.add(new BlogData(R.drawable.hair_care, "", "MAKEUP"));
        blogDatas.add(new BlogData(R.drawable.face, "", "NAIL"));
        blogDatas.add(new BlogData(R.drawable.hair_care, "", "BODY"));
        blogDatas.add(new BlogData(R.drawable.face, "", "MASSAGE AND SPA"));
        blogDatas.add(new BlogData(R.drawable.hair_care, "", "EXCLUSIVE OFFERS"));

    }

    private void setup_recyclerview(View view)
    {

        blog_recyclerview = (RecyclerView) view.findViewById(R.id.blog_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        blog_recyclerview.setLayoutManager(mLayoutManager);

        blogAdapter = new BlogAdapter(getActivity(), blogDatas);
        blog_recyclerview.setAdapter(blogAdapter);
    }


    private void setuptoolbar()
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("BLOG");

    }

}
