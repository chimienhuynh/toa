package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class ResourceActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "ResourceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        Button documentguidelines_btn= (Button)(findViewById(R.id.documentguidelines));
        documentguidelines_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOut = new Intent(ResourceActivity.this, GuidelinesActivity.class);
                startActivity(logOut);
            }
        });

       Button documentmaintenanceguide_btn= (Button)(findViewById(R.id.documentmaintenanceguide));
        documentmaintenanceguide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOut = new Intent(ResourceActivity.this, ResourceMaintenanceGuideActivity.class);
                startActivity(logOut);
            }
        });

        Button worksheet_btn= (Button)(findViewById(R.id.worksheet));
        worksheet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOut = new Intent(ResourceActivity.this, ResourceWorkSheetActivity.class);
                startActivity(logOut);
            }
        });

    }
}