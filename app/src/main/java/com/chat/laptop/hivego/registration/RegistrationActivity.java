package com.chat.laptop.hivego.registration;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.otpverify.OTPVerifyActivity;

public class RegistrationActivity extends AppCompatActivity {


    Button signup;
    TextView title_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        setuptoolbar();

        setup_layout();

        setup_font();


    }

    private void setup_layout() {

        signup = (Button) findViewById(R.id.signUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent otp = new Intent(RegistrationActivity.this, OTPVerifyActivity.class);
                startActivity(otp);

            }
        });
    }

    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_txt = (TextView) findViewById(R.id.title_txt);

        title_txt.setText("CREATE AN ACCOUNT");

    }


    private void setup_font() {



        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        title_txt.setTypeface(tf);
        signup.setTypeface(tf);

    }

}
