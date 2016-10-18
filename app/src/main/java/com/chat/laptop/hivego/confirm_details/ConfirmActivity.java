package com.chat.laptop.hivego.confirm_details;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.introduction.DefaultIntro;
import com.chat.laptop.hivego.salon.NearestSalonActivity;
import com.chat.laptop.hivego.tutorial.TutorialActivity;

public class ConfirmActivity extends AppCompatActivity {

    Button confirmButton;
    TextView toolbar_title_txt,titleTxt;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        setuptoolbar();

        setup_layout();

        setup_font();

    }

    private void setup_layout() {

        confirmButton = (Button) findViewById(R.id.confirmButton);

        titleTxt = (TextView) findViewById(R.id.titleTxt);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otp = new Intent(ConfirmActivity.this, TutorialActivity.class);
                startActivity(otp);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }


    private void setuptoolbar()
    {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title_txt = (TextView) findViewById(R.id.title_txt);

        toolbar_title_txt.setText("LOOKS GOOD?");

    }

    private void setup_font() {

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "Lato-Regular.ttf");

        toolbar_title_txt.setTypeface(tf);
        titleTxt.setTypeface(tf);
        confirmButton.setTypeface(tf);
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
