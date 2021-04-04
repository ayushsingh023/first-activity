//package com.example.firstactivity.model;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//
//import androidx.annotation.Nullable;
//
//import java.util.Random;
//
//public class BoundedServiceDemo extends Service {
//    private final IBinder binder = new MyBinnder();
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return binder;
//    }
//    public class MyBinder extends Binder
//    {
//        public  BoundedServiceDemo getService()
//        {
//         return  BoundedServiceDemo.this;
//        }
//    }
//
//    @Override
//    public boolean onUnbind(Intent intent)
//    {
//        return super.onUnbind(intent);
//    }
//
//    @Override
//    public void onRebind(Intent intent) {
//        super.onRebind(intent);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//    public int generateNumber(){
//        Random random=new Random();
//        return num;
//    }
//}
