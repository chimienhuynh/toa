package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class GuruProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "GuruProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guruprofile);


        Button button= (Button)(findViewById(R.id.guru_profile_logout));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
                Intent intent = new Intent(GuruProfileActivity.this, AuthenticationActivity.class);
                startActivity(intent);
            }
        });

    }
}
