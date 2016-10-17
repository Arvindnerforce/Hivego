package com.chat.laptop.hivego.otpverify;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.confirm_details.ConfirmActivity;

public class OTPVerifyActivity extends AppCompatActivity
{


    Button retryotp;
    TextView toolbar_title_txt,tittleTxt,otpNotRespond;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);

        setuptoolbar();

        setup_layout();



    }



    private void setuptoolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);

        toolbar_title_txt.setText("ENTER OTP");

    }


    private void setup_layout() {

        retryotp = (Button) findViewById(R.id.retryButton);

        tittleTxt = (TextView) findViewById(R.id.tittleTxt);

        otpNotRespond = (TextView) findViewById(R.id.otpNotRespond);

        retryotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent otp = new Intent(OTPVerifyActivity.this, ConfirmActivity.class);
                startActivity(otp);

            }
        });

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
        tittleTxt.setTypeface(tf);
        retryotp.setTypeface(tf);
        otpNotRespond.setTypeface(tf);


    }

}
