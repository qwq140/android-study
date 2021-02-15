package com.cos.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
// activity 화면
// 메인쓰레드 => onCreate() => UI 쓰레드 (무한루프[A버튼, B버튼])
//                         => 이벤트 리스너(OS)[A버튼, B버튼]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    
    private TextView tvTitle;
    private LinearLayout linearLayout;

    // 매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // 그림 그리는 함수 (무엇을? activity_main) => 자바

        Log.d(TAG, "onCreate: ");
    } // onCreate 종료시에 그림 그려짐.

    // 앱 멈출때
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // 화면 그려지기 직전!! -> 데이터 다운로드
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);
        String title = sp.getString("title","없음");
        Log.d(TAG, "onResume: "+title);

    }

    // 앱 종료시~~!!
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        // 1.파일 -> 그림, 사진 저장
        // 2.내부 DB = (SQL Lite) -> 주소록, 메모장, 달력
        // 3.외부 서버 = 외부 DB -> 인스타그램 업로드할 사진
        // 4. 메모리 엑세스 저장소 (제일 많이 씀) = 앱마다 달려있음. = 실제로는 한개 (키로 구분) = Sheared Preference
        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("title","바람과 함께 사라지다.");
        editor.commit(); // 영구히 기록
    }
}