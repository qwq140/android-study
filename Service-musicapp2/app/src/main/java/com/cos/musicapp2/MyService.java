package com.cos.musicapp2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;
    private final IBinder mBinder = new LocalBinder();

    class LocalBinder extends Binder{
        MediaPlayer getMp(){
            return mp;
        }
    }

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.sample1);
    }

    @Override
    public IBinder onBind(Intent intent) { // 바인드를 한다는 건 MainActivity에서 서비스 제어가 가능함.
        // TODO: Return the communication channel to the service.
        return mBinder; // 메인액티비티에 리턴
    }

}