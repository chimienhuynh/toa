package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.R;

public class ProfileActivity extends AppCompatActivity {
    Button bt_fan;
    Button bt_guru;
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bt_fan = (Button) findViewById(R.id.bt_fan);
        bt_guru = (Button) findViewById(R.id.bt_guru);
     preferences=   getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);


        bt_guru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit().putString(Constants.ACCOUNT_TYPE,"1").apply();
                startActivity(new Intent(ProfileActivity.this,HomePageActivity.class));
            }
        });

        bt_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit().putString(Constants.ACCOUNT_TYPE,"2").apply();
                startActivity(new Intent(ProfileActivity.this,HomePageActivity.class));
            }
        });
    }
}
