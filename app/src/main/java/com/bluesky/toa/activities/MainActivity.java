package com.bluesky.toa.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.bluesky.toa.R;
import com.bluesky.toa.data.utils.AWSClientFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize AWS Client
        AWSClientFactory.init(getApplicationContext());
        AWSAppSyncClient mAWSAppSyncClient = AWSClientFactory.appSyncClient();

        Button signOutButton = findViewById(R.id.sign_out_button);
        signOutButton.setText("Sign out");
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AWSMobileClient.getInstance().signOut();
            }
        });
    }
}
