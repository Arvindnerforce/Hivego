package com.chat.laptop.hivego.unavailable;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.widget.TextView;

import com.chat.laptop.hivego.R;

public class UnavailableActivity extends AppCompatActivity {


    TextView noserviceTxt,toolbar_title_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unavailable);

        setuptoolbar();

        setup_layout();

        setup_font();

    }


    private void setup_layout() {



        noserviceTxt = (TextView) findViewById(R.id.noserviceTxt);

    }


    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);

        toolbar_title_txt.setText("UNAVAILABLE");



    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        toolbar_title_txt.setTypeface(tf);
        noserviceTxt.setTypeface(tf);

    }

}
