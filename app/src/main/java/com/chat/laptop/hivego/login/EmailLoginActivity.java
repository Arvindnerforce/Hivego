package com.chat.laptop.hivego.login;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.registration.RegistrationActivity;

public class EmailLoginActivity extends AppCompatActivity implements View.OnClickListener
{


    Button loginButton,resetButton;
    TextView title_txt,forgetPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_email_login);

        setuptoolbar();

        setup_layout();

        setup_font();


    }

    private void setup_layout()
    {

        loginButton = (Button) findViewById(R.id.loginButton);

        resetButton = (Button) findViewById(R.id.resetButton);

        forgetPassword = (TextView) findViewById(R.id.forgetPassword);

        forgetPassword.setOnClickListener(this);

        loginButton.setOnClickListener(this);



    }

    private void setuptoolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_txt = (TextView) findViewById(R.id.title_txt);

        title_txt.setText("LOGIN");

    }

    private void setup_font()
    {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        title_txt.setTypeface(tf);
        loginButton.setTypeface(tf);
        forgetPassword.setTypeface(tf);
        resetButton.setTypeface(tf);

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

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {

            case R.id.loginButton:

                Intent ragister = new Intent(EmailLoginActivity.this, RegistrationActivity.class);
                startActivity(ragister);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case R.id.forgetPassword:

                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.custom_dialog);

                TextView text = (TextView) dialog.findViewById(R.id.character);
                // text.setText(msg);

                Button dialogButton = (Button) dialog.findViewById(R.id.cancel);

                Button ok = (Button) dialog.findViewById(R.id.submit);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {

                        dialog.dismiss();


                    }
                });

                dialog.show();

             break;


        }
    }
}
