package com.chat.laptop.hivego.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.introduction.DefaultIntro;

public class LoginActivity extends AppCompatActivity {

    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        createAccount = (Button) findViewById(R.id.createAccount);

        createAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, DefaultIntro.class);
                startActivity(i);
            }
        });
    }
}
