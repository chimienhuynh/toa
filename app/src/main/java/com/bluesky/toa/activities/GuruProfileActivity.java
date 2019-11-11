package com.bluesky.toa.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class GuruProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "GuruProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guruprofile);

        Button button= (Button)(findViewById(R.id.logout));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOut = new Intent(GuruProfileActivity.this, AuthenticationActivity.class);
                startActivity(logOut);
            }
        });

    }
}
