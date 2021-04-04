//package com.example.firstactivity.model;
//
//import android.app.Service;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.IBinder;
//
//import androidx.annotation.Nullable;
//
//import com.example.firstactivity.R;
//
//public class ServiceDemo extends Service implements MediaPlayer.OnCompletionListener {
//    MediaPlayer mp;
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mp=MediaPlayer.create(this,R.raw.countdown);
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        if (!mp.isPlaying())
//        {
//            mp.start();
//        }
//        return START_STICKY;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mp.stop();
//        mp.release();
//    }
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//        stopSelf();
//    }
//}
