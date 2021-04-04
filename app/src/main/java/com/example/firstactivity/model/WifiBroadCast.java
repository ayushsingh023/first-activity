package com.example.firstactivity.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.util.List;

public class WifiBroadCast extends BroadcastReceiver {
    WifiManager wm;
    @Override

    public void onReceive(Context context, Intent intent) {
        wm=(WifiManager)(context.getSystemService(Context.WIFI_SERVICE));
        List<ScanResult> w=wm.getScanResults();
        for(ScanResult s:w)
        {
            Toast.makeText(context, ""+s.SSID+"||"+s.BSSID+"||"+s.level, Toast.LENGTH_SHORT).show();
        }
    }
}
