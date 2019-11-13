package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class FanProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "FanProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanprofile);

        Button button= (Button)(findViewById(R.id.fan_profile_logout));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
                Intent intent = new Intent(FanProfileActivity.this, AuthenticationActivity.class);
                startActivity(intent);
            }
        });

    }
}
