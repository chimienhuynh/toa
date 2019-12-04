package com.bluesky.toa.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.models.Fan;
import com.bluesky.toa.ui.chat.models.User;
import com.google.gson.Gson;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class FanProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "FanProfileActivity";
    ImageView iv_back;
    ImageView  iv_logout;
    Button bt_update;
    CircleImageView editcircular_image;
    TextView mNameTv, mLocationTv;
    TextView mGenderTv;

    private SharedPreferences sharedPreferences;
    private final int PROFILE_UPDATE_REQUEST = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanprofile);
        sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);

        iv_back = findViewById(R.id.iv_back_fanprofile);
        iv_logout = findViewById(R.id.iv_logout);
       // iv_logout = findViewById(R.id.iv_logout);
        bt_update = findViewById(R.id.bt_update_fanprofile);
        editcircular_image = findViewById(R.id.edit_circular_image);
        mNameTv = findViewById(R.id.name_tv);
        mLocationTv = findViewById(R.id.location_tv);
        mGenderTv = findViewById(R.id.gender_tv);
        updateViews();

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FanProfileActivity.this, ProfileEditFan.class);
                startActivityForResult(i, PROFILE_UPDATE_REQUEST);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        iv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
            }
        });

        //        Button button= (Button)(findViewById(R.id.logout));
       /* iv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
            }
        });
*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PROFILE_UPDATE_REQUEST) {
            updateViews();
        }
    }

    private void updateViews() {
        Fan fan = new Gson().fromJson(sharedPreferences.getString(Constants.FAN_SHARED, null), Fan.class);
        if (fan != null) {
            mNameTv.setText(fan.getName());
            mLocationTv.setText(fan.getLocation());
            mGenderTv.setText(fan.getGender());

            if (fan.getImage() != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(fan.getImage(), 0, fan.getImage().length);
                editcircular_image.setImageBitmap(bitmap);
            }
        }
    }
}

