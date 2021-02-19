package com.cos.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;

import com.cos.myapplication.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private Toolbar toolbarMain;
    private ImageView ivPerson, ivMenu;
    private DrawerLayout drawer;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        ivPerson = findViewById(R.id.iv_person);
        ivMenu = findViewById(R.id.iv_menu);
        drawer = findViewById(R.id.drawer);

        Intent intent = new Intent(MainActivity.this,PersonActivity.class);
        ivPerson.setOnClickListener(v -> {
            startActivity(intent);
        });

        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(Gravity.LEFT);
        });

        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(MainActivity.this,nv);


    }

}