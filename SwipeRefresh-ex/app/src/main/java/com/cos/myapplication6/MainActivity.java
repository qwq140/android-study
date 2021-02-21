package com.cos.myapplication6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cos.myapplication6.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private List<Integer> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        listView = findViewById(R.id.list_view);
        items = new ArrayList<>();

        //초기값 설정
        items.add(10);
        items.add(20);
        items.add(30);
        items.add(40);
        items.add(50);
        items.add(60);
        items.add(70);

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_dark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                insertData();
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void insertData(){
        Random r = new Random();
        int ranNum = r.nextInt(100)+1;
        items.add(ranNum);
        Collections.sort(items);
    }
}

