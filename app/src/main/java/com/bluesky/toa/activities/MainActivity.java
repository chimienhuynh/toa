package com.bluesky.toa.activities;

import android.os.Bundle;

import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.bluesky.toa.R;
import com.bluesky.toa.data.AWSClientFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize AWS Client
        AWSClientFactory.init(getApplicationContext());
        AWSAppSyncClient mAWSAppSyncClient = AWSClientFactory.appSyncClient();
    }
}
