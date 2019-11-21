package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.ChatActivity;
import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Xue Nian Jiang
 * Home page for homepage functions and navigate to Connect, Features, Profile
 */

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button homepageBtn1 = findViewById(R.id.imageButton1_hp_jj);
        Button homepageBtn2 = findViewById(R.id.imageButton2_hp_jj);
        Button homepageBtn3 = findViewById(R.id.imageButton3_hp_jj);
        Button homepageBtn4 = findViewById(R.id.imageButton4_hp_jj);
        Button homepageBtn5 = findViewById(R.id.imageButton5_hp_jj);
        Button homepageBtn6 = findViewById(R.id.imageButton6_hp_jj);

        Button homepageBottomBtn1 = findViewById(R.id.imageButton_btm1_hp_jj);
        Button homepageBottomBtn2 = findViewById(R.id.imageButton_btm2_hp_jj);
        Button homepageBottomBtn3 = findViewById(R.id.imageButton_btm3_hp_jj);
        Button homepageBottomBtn4 = findViewById(R.id.imageButton_btm4_hp_jj);
        Button homepageBottomBtn5 = findViewById(R.id.imageButton_btm5_hp_jj);

        homepageBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(HomePageActivity.this, ChatActivity.class);
                Intent intent = new Intent(HomePageActivity.this, ForumActivity.class);

                startActivity(intent);
            }
        });

        homepageBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DashBoardActivity.class);
                startActivity(intent);
            }
        });

        homepageBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, FeaturesActivity.class);
                startActivity(intent);
            }
        });

        homepageBtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ResourceActivity.class);
                startActivity(intent);
            }
        });

        homepageBtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, RewardActivity.class);
                startActivity(intent);
            }
        });

        homepageBtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(HomePageActivity.this, DashBoardActivity.class);
                Intent intent = new Intent(HomePageActivity.this, SupportActivity.class);

                startActivity(intent);
            }
        });

        homepageBottomBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        homepageBottomBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        homepageBottomBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(HomePageActivity.this, FanProfileActivity.class);
                Intent intent = new Intent(HomePageActivity.this, MarketPlaceActivity.class);

                startActivity(intent);
            }
        });

        homepageBottomBtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        homepageBottomBtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, GuruProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}
