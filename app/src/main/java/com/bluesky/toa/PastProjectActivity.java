package com.bluesky.toa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.activities.DashBoardActivity;
import com.bluesky.toa.activities.HomePageActivity;

public class PastProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_project);

        Button projectDasboardBtnEPF = findViewById(R.id.imageButton_edit_profile_pdb_jj);
        Button projectDasboardBtnHP = findViewById(R.id.imageButton_home_page_pdb_jj);
        Button projectDasboardBtnMPDB = findViewById(R.id.imageButton_view_main_pdb_jj);

        projectDasboardBtnEPF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(PastProjectActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnHP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(PastProjectActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnMPDB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(PastProjectActivity.this, DashBoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
