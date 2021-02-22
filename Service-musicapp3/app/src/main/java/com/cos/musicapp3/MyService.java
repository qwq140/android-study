package com.cos.musicapp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;
    private final IBinder mBinder = new LocalBinder();

    class LocalBinder extends Binder {
        MediaPlayer getMp(){
            Log.d(TAG, "getMp: LocalBinder getMp");
            return mp;
        }
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        mp=MediaPlayer.create(this,R.raw.sample1);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}