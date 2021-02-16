package com.cos.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

// stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트

        mainLayout = findViewById(R.id.main_layout);
        fabRoute = findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(v -> {
            // 1.현재 내화면, 이동할 화면
            // 2.현재 내화면, 내부앱의 이동할 화면 (안드로이드 os가 기본적으로 가지고 있는 것)
            //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));
            // 인텐트 = 트럭(현재 내위치, 이동할 위치정보, 이동할 때 가져갈 박스)
            // 다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)
            User user = new User();
            user.setId(1);
            user.setUsername("cos");
            user.setPassword("1234");

            // Bundle (택배박스)
            // serializable
            // gson으로 json변환 putExtra로 넘기고 gson으로 자바 오브젝트

            Intent intent = new Intent(mContext, SubActivity.class);
            // Bundle
            //Bundle bundle = new Bundle();
            //bundle.putSerializable("user",user);
            //intent.putExtra("userBundle",bundle);

            // serializable (이거 사용)
            intent.putExtra("user", user);

            // gson
            //Gson gson = new Gson();
            //String json = gson.toJson(user);
            //intent.putExtra("jsonData",json);

            //startActivity(intent);

            startActivityForResult(intent,300); // 콜백 받고 싶을 때 사용
        });
    }

    // finish() 될때 콜백되는 함수
    // setResult() 함수의 파라메터가 전달됨.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: 실행됨");
        Log.d(TAG, "requestCode: "+requestCode);
        Log.d(TAG, "resultCode: "+resultCode);

        // Window 가 무엇인지? AlertDialog 사용

        if(requestCode == 300) {
            if(resultCode == -1){ // 로직 성공
                //Toast.makeText(mContext, "인증 성공함 "+data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout,"인증 성공함", BaseTransientBottomBar.LENGTH_LONG).show();
            } else { // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}