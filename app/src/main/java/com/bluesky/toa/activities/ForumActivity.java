package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bluesky.toa.R;

public class ForumActivity extends AppCompatActivity {


    ImageView iv_back;
    RelativeLayout rl_onlinecomunity;
    RelativeLayout rl_findclub;

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
