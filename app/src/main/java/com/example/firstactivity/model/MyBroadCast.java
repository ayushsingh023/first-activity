package com.example.firstactivity.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MESSAGE FROM BROADCAST", Toast.LENGTH_SHORT).show();
    }
}
