package com.cos.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private ImageView iv1;
    private FontTextView ftv;
    private ImageView iv2;
    private boolean isSolid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ftv = findViewById(R.id.ftv);
        iv2 = findViewById(R.id.iv_2);

        FontDrawable drawable = new FontDrawable(this,R.string.fa_heart,isSolid,false);



        iv2.setImageDrawable(drawable);

        iv2.setOnClickListener(v -> {
            isSolid = !isSolid;
            FontDrawable drawable2 = new FontDrawable(this,R.string.fa_heart, isSolid,false);
            iv2.setImageDrawable(drawable2);

        });

        iv1=findViewById(R.id.iv_1);

        Glide
                .with(MainActivity.this)
                .load("https://picsum.photos/200/300")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(iv1);

    }

}