package com.cos.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvImageList;
    private MovieAdapter movieAdapter;
    private Integer movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        List<Integer> movies = download();
        movieAdapter = new MovieAdapter(movies);

        rvImageList.setAdapter(movieAdapter);

    }

    private void init(){
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rvImageList = findViewById(R.id.rv_image_list);
        rvImageList.setLayoutManager(manager);
    }

    // 가짜 다운로드
    private List<Integer> download(){
        List<Integer> movies = new ArrayList<>();
        movies.add(R.drawable.mov01);
        movies.add(R.drawable.mov02);
        movies.add(R.drawable.mov03);
        movies.add(R.drawable.mov04);
        movies.add(R.drawable.mov05);
        movies.add(R.drawable.mov06);
        movies.add(R.drawable.mov07);
        movies.add(R.drawable.mov08);
        movies.add(R.drawable.mov09);
        movies.add(R.drawable.mov10);
        movies.add(R.drawable.mov11);
        movies.add(R.drawable.mov12);
        return movies;
    }
}