package com.bluesky.toa.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.models.User;
import com.google.gson.Gson;

import de.hdodenhof.circleimageview.CircleImageView;

public class GuruProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "GuruProfileActivity";
    ImageView iv_back, iv_logout;
    Button bt_update;
    CircleImageView editcircular_image;
    TextView mNameTv, mLocationTv, mBioTv, mCompanyNameTv;
    TextView mGenderTv;
    Spinner mServiceSpinner;

    private SharedPreferences sharedPreferences;
    private final int PROFILE_UPDATE_REQUEST = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guruprofile);

        sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);

        iv_back = findViewById(R.id.iv_back_guruprofile);
        iv_logout = findViewById(R.id.iv_logout);
        bt_update = findViewById(R.id.bt_update_guruprofile);
        editcircular_image = findViewById(R.id.edit_circular_image);
        mNameTv = findViewById(R.id.name_tv);
        mLocationTv = findViewById(R.id.location_tv);
        mBioTv = findViewById(R.id.bio_tv);
        mCompanyNameTv = findViewById(R.id.company_name_tv);
        mGenderTv = findViewById(R.id.gender_tv);
        mServiceSpinner = findViewById(R.id.service_spinner);
        updateViews();

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GuruProfileActivity.this, ProfileEditGuru.class);
                startActivityForResult(i, PROFILE_UPDATE_REQUEST);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PROFILE_UPDATE_REQUEST) {
            updateViews();
        }
    }

    private void updateViews() {
        User user = new Gson().fromJson(sharedPreferences.getString(Constants.GURU_SHARED, null), User.class);
        if (user != null) {
            mNameTv.setText(user.getName());
            mLocationTv.setText(user.getLocation());
            mBioTv.setText(user.getBio());
            mCompanyNameTv.setText(user.getCompany_name());
            mGenderTv.setText(user.getGender());
            mServiceSpinner.setSelection(user.getService());

            if (user.getImage() != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(user.getImage(), 0, user.getImage().length);
                editcircular_image.setImageBitmap(bitmap);
            }
        }
    }
}
