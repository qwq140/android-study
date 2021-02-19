package com.cos.myapplication.helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cos.myapplication.MainActivity;
import com.cos.myapplication.PersonActivity;
import com.cos.myapplication.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enable(Context context, NavigationView view){
        view.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if(id == R.id.item1){
                Log.d(TAG, "onCreate: 메뉴1 클릭됨");
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item2){
                Log.d(TAG, "onCreate: 메뉴2 클릭됨");
                Intent intent = new Intent(context, PersonActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item3){
                Log.d(TAG, "onCreate: 메뉴3 클릭됨");
            }

            return false;
        });
    }

}
