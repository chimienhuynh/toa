package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bluesky.toa.R;

public class FeaturesActivity extends AppCompatActivity {


    ImageView iv_back;
    RelativeLayout rl_extert;
    RelativeLayout rl_project;
    RelativeLayout rl_insight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        iv_back = (ImageView) findViewById(R.id.iv_back_features);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rl_extert = (RelativeLayout) findViewById(R.id.rl_expert_features);
        rl_project = (RelativeLayout) findViewById(R.id.rl_project_feature);
        rl_insight = (RelativeLayout) findViewById(R.id.rl_insight_feature);
        rl_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeaturesActivity.this, ProjectActivity.class);
                startActivity(i);
            }
        });

        rl_insight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeaturesActivity.this, InsightActivity.class);
                startActivity(i);

            }
        });
        rl_extert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeaturesActivity.this, ExpertActivity.class);
                startActivity(i);

            }
        });
    }
}
