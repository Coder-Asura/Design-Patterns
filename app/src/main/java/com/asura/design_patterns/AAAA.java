package com.asura.design_patterns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Asura on 2018/3/23 17:10.
 */
public class AAAA extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PatternsAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        initData();
    }

    private void initData() {
        final List<String> names = new ArrayList<>();
        names.add("六大原则");
        names.add("单例模式");
        names.add("Builder模式");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(AAAA.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new PatternsAdapter(names, new PatternsAdapter.CallBack() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(AAAA.this, names.get(position), Toast.LENGTH_SHORT).show();
            }
        }));

        Toast.makeText(AAAA.this, getIntent().getStringExtra("content"), Toast.LENGTH_SHORT).show();
    }
}
