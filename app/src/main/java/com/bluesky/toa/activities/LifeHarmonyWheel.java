package com.bluesky.toa.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.bluesky.toa.R;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class LifeHarmonyWheel extends AppCompatActivity {

    boolean buttonRotation = true;
    int intNumber = 6;
    SharedPreferences sharedPreferences;
    private ImageView lifeharmony;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    private Button spinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_life_harmony_wheel);

        lifeharmony = findViewById(R.id.life_wheel);
        spinButton = findViewById(R.id.buttonspin);

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.intNumber = this.sharedPreferences.getInt("INT_Number", 6);

    }

    public void spinLifeHarmony(View v){
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            if(!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = lifeharmony.getWidth() / 2;
            float prvotY = lifeharmony.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, prvotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            lifeharmony.startAnimation(rotate);
        }
            }
        });
    }
}

