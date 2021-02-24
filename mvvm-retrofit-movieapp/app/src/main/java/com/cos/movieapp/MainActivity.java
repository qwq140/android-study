package com.cos.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.cos.movieapp.adapter.MovieAdapter;
import com.cos.movieapp.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private MovieViewModel movieViewModel;
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        // 1,2,3 => 1,2,3,4
        // 1,2,3 => 1,2
        movieViewModel.구독().observe(this,posts -> {
            Log.d(TAG, "onCreate: 데이터 변경됨");
            movieAdapter.setPosts(posts);
        });

        // 1.레트로핏에 findAll 요청
        movieViewModel.전체가져오기();



    }
    private void init(){
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.데이터초기화();

        rvMovie = findViewById(R.id.rv_movie);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
        rvMovie.setLayoutManager(manager);
        movieAdapter = new MovieAdapter(movieViewModel);
        rvMovie.setAdapter(movieAdapter);

    }



}