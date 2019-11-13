package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bluesky.toa.R;

public class RewardActivity extends AppCompatActivity {


    ImageView iv_back;
    CardView cv_accounthistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        iv_back = (ImageView) findViewById(R.id.iv_back_reward);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        cv_accounthistory = (CardView) findViewById(R.id.cv_accounthistory_rewards);
        cv_accounthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RewardActivity.this, TransactionsActivity.class);
                startActivity(i);
            }
        });
    }
}
