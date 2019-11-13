package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bluesky.toa.R;
import com.bluesky.toa.adapter.ClubsAdapter;
import com.bluesky.toa.adapter.CommunityAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommunitiesActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ImageView iv_back;
    CommunityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communities);
        recyclerView = (RecyclerView) findViewById(R.id.rv_community);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(CommunitiesActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new CommunityAdapter();
        recyclerView.setAdapter(adapter);
        iv_back = (ImageView) findViewById(R.id.iv_back_community);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("1 Community");
        list.add("2 Community");
        list.add("3 Community");
        adapter.update(list);
    }
}
