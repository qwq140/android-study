package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;

import com.cos.myapplication2.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    
    private DrawerLayout drawer;
    private Button btn1;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            drawer.openDrawer(Gravity.LEFT);
        });
        
        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(MainActivity.this, nv);
    }
}