package com.bluesky.toa.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bluesky.toa.R;
import com.bluesky.toa.adapter.ClubsAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ClubsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ImageView iv_back;
    ClubsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        recyclerView = (RecyclerView) findViewById(R.id.rv_clubs);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(ClubsActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new ClubsAdapter();
        recyclerView.setAdapter(adapter);
        iv_back = (ImageView) findViewById(R.id.iv_back_clubs);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("1 Clubs");
        list.add("2 Clubs");
        list.add("3 Clubs");
        adapter.update(list);
    }
}
