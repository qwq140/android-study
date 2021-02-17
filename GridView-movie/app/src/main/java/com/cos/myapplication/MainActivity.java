package com.cos.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private GridView gvMovie;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        ItemAdapter adapter = new ItemAdapter(movies);

        gvMovie.setAdapter(adapter);

    }
    private void init(){
        gvMovie=findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        download();
    }

    private void download(){
        movies.add(new Movie(1, "써니", R.drawable.mov01));
        movies.add(new Movie(2, "완득이", R.drawable.mov02));
        movies.add(new Movie(3, "괴물", R.drawable.mov03));
        movies.add(new Movie(4, "라디오스타", R.drawable.mov04));
        movies.add(new Movie(5, "비열한거리", R.drawable.mov05));
        movies.add(new Movie(6, "왕의남자", R.drawable.mov06));
        movies.add(new Movie(7, "아일랜드", R.drawable.mov07));
        movies.add(new Movie(8, "웰컴투동막골", R.drawable.mov08));
        movies.add(new Movie(9, "헬보이", R.drawable.mov09));
        movies.add(new Movie(10, "백투더피쳐", R.drawable.mov10));
        movies.add(new Movie(11, "여인의향기", R.drawable.mov11));
        movies.add(new Movie(12, "쥬라기공원", R.drawable.mov12));
    }
}