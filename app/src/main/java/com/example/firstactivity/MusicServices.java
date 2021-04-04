//package com.example.firstactivity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.ComponentName;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.IBinder;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.example.firstactivity.model.BoundedServiceDemo;
//import com.example.firstactivity.model.ServiceDemo;
//
//public class MusicServices extends AppCompatActivity implements View.OnClickListener {
//    Button start,stop,getnum;
//    Intent intent;
//    BoundedServiceDemo boundedService;
//    boolean isbound=false;
//    private ServiceConnection serviceConnection=new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            BoundedServiceDemo.MyBinder binder=(BoundedServiceDemo.MyBinder)service;
//            boundedService=binder.getService();
//            isbound=true;
//            Toast.makeText(boundedService, "Service Connected", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            isbound=false;
//            boundedService=null;
//            Toast.makeText(boundedService, "Service Dis-Connected", Toast.LENGTH_SHORT).show();
//        }
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_music_services);
//        start=findViewById(R.id.start);
//        stop=findViewById(R.id.stop);
//        getnum=findViewById(R.id.getnum);
//        start.setOnClickListener(this);
//        stop.setOnClickListener(this);
//        getnum.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        intent=new Intent(MusicServices.this, ServiceDemo.class);
//        switch (v.getId())
//        {
//            case R.id.start:
//                startService(intent);
//                break;
//            case R.id.stop:
//                stopService(intent);
//                break;
//            case R.id.getnum:
//                randomNumber();
//                break;
//        }
//
//    }
//    private void randomNumber()
//    {
//        Intent intent=new Intent(this,BoundedServiceDemo.class);
//        startService(intent);
//        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MusicServices.this, String.valueOf(boundedService.generateNumber()), Toast.LENGTH_SHORT).show();
//            }
//        },3000);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (isbound)
//        {
//            unbindService(serviceConnection);
//            isbound=false;
//        }
//    }
//}