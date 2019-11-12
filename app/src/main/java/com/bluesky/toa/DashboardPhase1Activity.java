package com.bluesky.toa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.activities.DashBoardActivity;
import com.bluesky.toa.activities.HomePageActivity;

public class DashboardPhase1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_phase1);

        Button projectDasboardBtn1 = findViewById(R.id.imageButton1_pdb_jj);

        Button projectDasboardBtnEPF = findViewById(R.id.imageButton_edit_profile_pdb_jj);
        Button projectDasboardBtnHP = findViewById(R.id.imageButton_home_page_pdb_jj);
        Button projectDasboardBtnVPP = findViewById(R.id.imageButton_view_past_project_pdb_jj);

        projectDasboardBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase1Activity.this, DashBoardActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnEPF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase1Activity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnHP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase1Activity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnVPP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashboardPhase1Activity.this, PastProjectActivity.class);
                startActivity(intent);
            }
        });
    }
}
