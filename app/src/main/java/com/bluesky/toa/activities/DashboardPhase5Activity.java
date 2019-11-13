package com.bluesky.toa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.R;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardPhase5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_phase5);

        Button projectDasboardBtn1 = findViewById(R.id.imageButton5_pdb_jj);

        Button projectDasboardBtnEPF = findViewById(R.id.imageButton_edit_profile_pdb_jj);
        Button projectDasboardBtnHP = findViewById(R.id.imageButton_home_page_pdb_jj);
        Button projectDasboardBtnVPP = findViewById(R.id.imageButton_view_past_project_pdb_jj);

        projectDasboardBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase5Activity.this, DashBoardActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnEPF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase5Activity.this, GuruProfileActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnHP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase5Activity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnVPP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase5Activity.this, PastProjectActivity.class);
                startActivity(intent);
            }
        });
    }
}
