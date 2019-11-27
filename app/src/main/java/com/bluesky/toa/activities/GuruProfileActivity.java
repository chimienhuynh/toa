package com.bluesky.toa.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;
import com.bluesky.toa.data.utils.AWSClientFactory;
import com.bluesky.toa.data.utils.ObjectBox;
import com.bluesky.toa.ui.chat.models.User;

import androidx.appcompat.app.AppCompatActivity;

import io.objectbox.Box;

public class GuruProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "GuruProfileActivity";
    ImageView iv_back, iv_logout;
    Button bt_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guruprofile);
        iv_back = (ImageView) findViewById(R.id.iv_back_guruprofile);
        iv_logout = (ImageView) findViewById(R.id.iv_logout);
        bt_update = (Button) findViewById(R.id.bt_update_guruprofile);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GuruProfileActivity.this, ProfileEditGuru.class);
                startActivity(i);
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //        Button button= (Button)(findViewById(R.id.logout));
        iv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
            }
        });

    }
}
