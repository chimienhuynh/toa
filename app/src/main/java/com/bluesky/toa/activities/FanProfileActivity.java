package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class FanProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "FanProfileActivity";
    ImageView iv_back;
    Button bt_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanprofile);
        iv_back = (ImageView) findViewById(R.id.iv_back_fanprofile);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        bt_update = (Button) findViewById(R.id.bt_update_fanprofile);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FanProfileActivity.this, ProfileEditFan.class);
                startActivity(i);
            }
        });
//        Button button= (Button)(findViewById(R.id.logout));
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent logOut = new Intent(FanProfileActivity.this, AuthenticationActivity.class);
//                startActivity(logOut);
//            }
//        });

    }
}
