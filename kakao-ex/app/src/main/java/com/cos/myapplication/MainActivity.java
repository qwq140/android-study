package com.cos.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.kakao_container, new ChatsFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.bottom_chats);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case  R.id.bottom_friends:
                    selectedFragment = new FriendsFragment();
                    break;
                case  R.id.bottom_chats:
                    selectedFragment = new ChatsFragment();
                    break;
                case  R.id.bottom_tags:
                    selectedFragment = new TagsFragment();
                    break;
                case  R.id.bottom_more:
                    selectedFragment = new MoreFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.kakao_container, selectedFragment).commit();
            return true;
        });

    }
}