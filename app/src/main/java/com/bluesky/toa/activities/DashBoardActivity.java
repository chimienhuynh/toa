package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluesky.toa.ChatActivity;
import com.bluesky.toa.R;

/**
 * @author Xue Nian Jiang
 * Project Dash Board for project management
 */


public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button projectDasboardBtn1 = findViewById(R.id.imageButton1_pdb_jj);
        Button projectDasboardBtn2 = findViewById(R.id.imageButton2_pdb_jj);
        Button projectDasboardBtn3 = findViewById(R.id.imageButton3_pdb_jj);
        Button projectDasboardBtn4 = findViewById(R.id.imageButton4_pdb_jj);
        Button projectDasboardBtn5 = findViewById(R.id.imageButton5_pdb_jj);
        Button projectDasboardBtn6 = findViewById(R.id.imageButton6_pdb_jj);
        Button projectDasboardBtn7 = findViewById(R.id.imageButton7_pdb_jj);
        Button projectDasboardBtn8 = findViewById(R.id.imageButton8_pdb_jj);

        Button projectDasboardBtnEPF = findViewById(R.id.imageButton_edit_profile_pdb_jj);
        Button projectDasboardBtnHP = findViewById(R.id.imageButton_home_page_pdb_jj);
        Button projectDasboardBtnVPP = findViewById(R.id.imageButton8_view_past_project_pdb_jj);

        projectDasboardBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtn8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnEPF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnHP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        projectDasboardBtnVPP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DashBoardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
