package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bluesky.toa.R;
import com.bluesky.toa.adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ImageView iv_back;
    NotificationAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView = (RecyclerView) findViewById(R.id.rv_notification);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotificationActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new NotificationAdapter();
        recyclerView.setAdapter(adapter);
        iv_back = (ImageView) findViewById(R.id.iv_back_notification);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("1 Notification");
        list.add("2 Notification");
        list.add("3 Notification");
        adapter.update(list);

    }
}
