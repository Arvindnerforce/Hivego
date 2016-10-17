package com.chat.laptop.hivego.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.introduction.DefaultIntro;

public class LoginActivity extends AppCompatActivity {

    Button createAccount;
    TextView facebook_txt,google_txt,haveAccount_txt,tems_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        setup_layout();

        setup_font();



    }

    private void setup_layout() {

        facebook_txt = (TextView) findViewById(R.id.facebookTxt);

        google_txt = (TextView) findViewById(R.id.googleTxt);

        haveAccount_txt = (TextView) findViewById(R.id.haveAccountTxt);

        tems_txt = (TextView) findViewById(R.id.termsTxt);

        createAccount = (Button) findViewById(R.id.createAccount);

        createAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, EmailLoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void setup_font() {



        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        facebook_txt.setTypeface(tf);
        google_txt.setTypeface(tf);
        haveAccount_txt.setTypeface(tf);
        tems_txt.setTypeface(tf);

        createAccount.setTypeface(tf);

    }
}
