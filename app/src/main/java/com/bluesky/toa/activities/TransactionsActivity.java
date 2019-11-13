package com.bluesky.toa.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bluesky.toa.R;
import com.bluesky.toa.adapter.TransactionsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ImageView iv_back;
    TransactionsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        recyclerView = (RecyclerView) findViewById(R.id.rv_transactions);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(TransactionsActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new TransactionsAdapter();
        recyclerView.setAdapter(adapter);
        iv_back = (ImageView) findViewById(R.id.iv_back_transactions);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        List<String> list = new ArrayList<>();
        list.add("1 Transaction");
        list.add("2 Transaction");
        list.add("3 Transaction");
        adapter.update(list);
    }
}
