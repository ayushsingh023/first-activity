package com.example.firstactivity.model;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BluetoothBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action.equals(BluetoothDevice.ACTION_FOUND))
        {
            BluetoothDevice bd=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            Toast.makeText(context, ""+bd.getName()+"||"+bd.getAddress(), Toast.LENGTH_SHORT).show();
        }
    }
}
