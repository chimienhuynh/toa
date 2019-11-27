package com.bluesky.toa.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainProfileActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "MainProfileActivity";
    private  static  final int RESULT_LOAD_IMAGE =1;
    ImageView imageUpload;
    Button saveButton;
    EditText upLoadName, upLoadLocation;
    CheckBox professional;
    CheckBox customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        imageUpload = (ImageView) findViewById(R.id.imageUpload);
        upLoadName = (EditText) findViewById(R.id.mainprofile_name);
        upLoadLocation = (EditText) findViewById(R.id.mainprofile_location);

        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });
        Button saveButton= (Button)(findViewById(R.id.mainprofile_save));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //AWSMobileClient.getInstance().signOut();

                //Intent intent = new Intent(FanProfileActivity.this, AuthenticationActivity.class);
                //startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && requestCode == RESULT_OK && data != null){
            Uri selectdImage = data.getData();
            imageUpload.setImageURI(selectdImage);
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.professional_register:
                professional.setChecked(true);
                customer.setChecked(false);

                break;
            case R.id.customer_register:
                professional.setChecked(false);
                customer.setChecked(true);
                break;

        }
    }
}
