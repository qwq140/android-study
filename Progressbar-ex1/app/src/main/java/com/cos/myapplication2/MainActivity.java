package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgerssBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트

        //pbg_loading은 실행시에 메모리에 뜸.
        //실행전에 컴파일시에 틀이 저 친구를 R에 등록을 해줌.
        mProgerssBar = findViewById(R.id.pgb_loading);

        download(); // 3초 = UI스레드
    }

    private void download(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // 다운로드 완료, 스프링 서버 요청 응답의 결과 (JSON)
                    mProgerssBar.setVisibility(View.INVISIBLE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}