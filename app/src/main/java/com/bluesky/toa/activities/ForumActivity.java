package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bluesky.toa.R;

public class ForumActivity extends AppCompatActivity {


    ImageView iv_back;
    RelativeLayout rl_onlinecomunity;
    RelativeLayout rl_findclub;
    TextView tv_awaits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        iv_back = (ImageView) findViewById(R.id.iv_back_forum);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rl_findclub = (RelativeLayout) findViewById(R.id.rl_findclub_forum);
        rl_onlinecomunity = (RelativeLayout) findViewById(R.id.rl_onlinecommunity_forum);
        tv_awaits = (TextView) findViewById(R.id.tv_awaits);
        SharedPreferences preferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        String accountype = preferences.getString(Constants.ACCOUNT_TYPE, "1");
        if (accountype.equals("1")) {
            tv_awaits.setText("Your Orginizing Customers Awaits");
        } else if (accountype.equals("2")) {
            tv_awaits.setText("YOUR ORGANIZERS AWAITS");

        } else {
            tv_awaits.setText("");
        }
        rl_findclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForumActivity.this, ClubsActivity.class);
                startActivity(i);
            }
        });
        rl_onlinecomunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForumActivity.this, CommunitiesActivity.class);
                startActivity(i);
            }
        });
    }
}
