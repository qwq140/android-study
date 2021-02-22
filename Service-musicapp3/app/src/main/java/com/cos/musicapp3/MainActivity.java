package com.cos.musicapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    // View
    private ImageView btnPlayStop;
    private SeekBar seekBar;
    private TextView tvTime;

    //음악 관련
    private int isPlaying = -1; // 1 : 음악재생, -1 : 음악멈춤
    private MyService myService;
    private MediaPlayer mp;

    // 쓰레드 관련
    Handler handler = new Handler();
    private Thread uiHandleThread;
    private boolean threadStatus = false;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: 서비스 연결됨");
            mp = ((MyService.LocalBinder)service).getMp();
            seekBarInit();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mp.stop();
            mp.release();
        }
    };

    public void seekBarInit(){
        seekBar.setMax(mp.getDuration());
        seekBar.setProgress(0);
    }

    public void musicStart(){
        mp.start();
        btnPlayStop.setImageResource(R.drawable.ic_pause);
    }

    public void musicPause(){
        mp.pause();
        btnPlayStop.setImageResource(R.drawable.ic_play);
    }

    public void musicStop(){
        mp.seekTo(0);
        btnPlayStop.setImageResource(R.drawable.ic_play);
        seekBar.setProgress(0);
        threadStatus = true;
        isPlaying = -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnPlayStop = findViewById(R.id.btn_play_stop);
        seekBar = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tv_time);

        // 서비스 바인딩 하기
        Intent musicIntent = new Intent(MainActivity.this, MyService.class);
        bindService(musicIntent,connection,BIND_AUTO_CREATE);

        btnPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = isPlaying * -1;
                if(isPlaying==1){
                    musicStart();
                } else {
                    musicPause();
                }

                uiHandleThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (isPlaying==1){
                            handler.post(new Runnable() { // Runnable 객체를 message queue에 전달하는 함수
                                @Override
                                public void run() {
                                    seekBar.setProgress(mp.getCurrentPosition());
                                    if(mp.getCurrentPosition() >= mp.getDuration()){
                                        musicStop();
                                    }
                                }
                            });
                            try {
                                Thread.sleep(1000);
                                if(threadStatus){
                                    uiHandleThread.interrupt();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                uiHandleThread.start();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 유저가 SeekBar를 클릭할 때
                if(fromUser){
                    mp.seekTo(progress);
                }

                int m = progress / 60000;
                int s = (progress%60000)/1000;
                String strTime = String.format("%02d:%02d",m,s);
                tvTime.setText(strTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}