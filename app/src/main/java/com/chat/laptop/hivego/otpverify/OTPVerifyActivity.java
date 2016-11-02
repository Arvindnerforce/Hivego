package com.chat.laptop.hivego.otpverify;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.confirm_details.ConfirmActivity;

import java.util.Timer;
import java.util.TimerTask;

public class OTPVerifyActivity extends AppCompatActivity
{


    Button retryotp;
    TextView toolbar_title_txt,tittleTxt,otpNotRespond,couter_textview;
    EditText editText1,editText2,editText3,editText4;
   int count = 00;

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

        couter_textview = (TextView) findViewById(R.id.couter_textview);

        editText1 = (EditText) findViewById(R.id.editText1);

        editText2 = (EditText) findViewById(R.id.editText2);

        editText3 = (EditText) findViewById(R.id.editText3);

        editText4 = (EditText) findViewById(R.id.editText4);


        retryotp = (Button) findViewById(R.id.retryButton);

        tittleTxt = (TextView) findViewById(R.id.tittleTxt);

        otpNotRespond = (TextView) findViewById(R.id.otpNotRespond);

        retryotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent otp = new Intent(OTPVerifyActivity.this, ConfirmActivity.class);
                startActivity(otp);
                overridePendingTransition(R.anim.enter, R.anim.exit);

            }
        });



        editText1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (editText1.getText().toString().length() == 1)     //size as per your requirement
                {
                    editText2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        editText2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText2.getText().toString().length()==1)     //size as per your requirement
                {
                    editText3.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });


        editText3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText3.getText().toString().length()==1)     //size as per your requirement
                {
                    editText4.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });



        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                couter_textview.setText("00: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                couter_textview.setText("00:00");
            }

        }.start();

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
        tittleTxt.setTypeface(tf);
        retryotp.setTypeface(tf);
        otpNotRespond.setTypeface(tf);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {

            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}
