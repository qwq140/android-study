package com.cos.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetailTitle;
    private ImageView tvDetailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Movie movie = (Movie) intent.getSerializableExtra("movie");

        tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvDetailImg = findViewById(R.id.tv_detail_img);

        tvDetailTitle.setText(movie.getTitle());
        tvDetailImg.setImageResource(movie.getPic());


    }
}