package com.chat.laptop.hivego.choose_trending_looks.bread;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.choose_trending_looks.choose_style.ChooseStyleFragment;
import com.chat.laptop.hivego.choose_trending_looks.choose_style.StyleList;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class BeardFragment extends Fragment
{

    TextView toolbar_title_txt;
    RelativeLayout short_layout,long_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beard, container, false);

        setuptoolbar(view);

        setup_font(view);


        setup_layout(view);

        return view;
    }

    private void setup_layout(View view) {

        short_layout  = (RelativeLayout) view.findViewById(R.id.short_layout);

        long_layout = (RelativeLayout) view.findViewById(R.id.long_layout);

        Picasso.with(getActivity()).load(R.drawable.ic_men_beard).into(new Target(){

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                short_layout.setBackground(new BitmapDrawable(getActivity().getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });


        Picasso.with(getActivity()).load(R.drawable.ic_men_long_beard).into(new Target(){

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                long_layout.setBackground(new BitmapDrawable(getActivity().getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });


      //  Picasso.with(getActivity()).load(R.drawable.ic_men_long_beard).into((Target) long_layout);

        short_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                ChooseStyleFragment chooseStyleFragment = new ChooseStyleFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, chooseStyleFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

            }
        });
    }


    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);
        toolbar_title_txt.setText("SIZE OF YOUR BEARD?");


    }

    private void setup_font(View view)
    {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }

}
