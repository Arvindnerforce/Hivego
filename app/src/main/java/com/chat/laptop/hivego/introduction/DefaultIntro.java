package com.chat.laptop.hivego.introduction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.registration.RegistrationActivity;


public final class DefaultIntro extends BaseIntro
{

    Bitmap icon;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        addSlide(SampleSlide.newInstance(R.layout.activity_intro_first));
        addSlide(SampleSlide.newInstance(R.layout.activity_intro_second));
        addSlide(SampleSlide.newInstance(R.layout.activity_intro_three));
        addSlide(SampleSlide.newInstance(R.layout.activity_intro_four));

        showSkipButton(false);

        //setSeparatorColor(Color.parseColor("#000000"));




    }




    public void getStarted(View v)
    {
        loadMainActivity();
    }




    private void addListener(View root)
    {
        if (root instanceof ViewGroup)
        {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++)
            {
                addListener(parent.getChildAt(i));
            }
        }
        else
        {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                   // mExplosionField.explode(v);
                    v.setOnClickListener(null);
                }
            });
        }
    }
}
