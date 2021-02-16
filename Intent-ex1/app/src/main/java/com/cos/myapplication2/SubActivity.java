package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    private FloatingActionButton fabPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        // Bundle
        //Bundle bundle = intent.getBundleExtra("userBundle");
        //User user = (User)bundle.getSerializable("user");


        // serializable
        User user = (User) intent.getSerializableExtra("user");

        // gson
        //String jsonData = intent.getStringExtra("jsonData");
        //Log.d(TAG, "jsonData : "+jsonData);
        //Gson gson = new Gson();
        //User user = gson.fromJson(jsonData, User.class);

        Log.d(TAG, "id:"+user.getId());
        Log.d(TAG, "username:"+user.getUsername());
        Log.d(TAG, "password:"+user.getPassword());

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            // 인증이 성공함
            Intent newIntent = new Intent();
            newIntent.putExtra("auth","ok");
            setResult(RESULT_OK,newIntent);
            finish(); // pop
        });
    }
}