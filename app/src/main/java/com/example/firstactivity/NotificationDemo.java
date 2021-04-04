package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDemo extends AppCompatActivity implements View.OnClickListener{
    Button b;
    NotificationManager nm;
    NotificationChannel nc;
    NotificationCompat.Builder ncb;
    final static public String CHANNEL_ID="mychannel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        b=findViewById(R.id.button);
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ncb=new NotificationCompat.Builder(this,CHANNEL_ID);
        ncb.setSmallIcon(android.R.drawable.sym_call_missed);
        ncb.setContentTitle("MISSED CALL");
        ncb.setContentText("You have missed call from 9999999999");
        ncb.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        createNotification();
        Intent intent=new Intent(this,Result.class);
        PendingIntent pi=PendingIntent.getActivity(this,1111,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        ncb.setContentIntent(pi);
        ncb.setAutoCancel(true);
        NotificationManagerCompat nmc=NotificationManagerCompat.from(this);
        nmc.notify(1111,ncb.build());
    }

    private void createNotification()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name=getString(R.string.channel_name);
            String des=getString(R.string.channel_dec);
            int imp=NotificationManager.IMPORTANCE_DEFAULT;
            nc=new NotificationChannel(CHANNEL_ID,name,imp);
            nc.setDescription(des);
            nm.createNotificationChannel(nc);
        }
    }
}