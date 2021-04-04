package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.firstactivity.model.WifiBroadCast;

public class WifiDemo extends AppCompatActivity {
    WifiManager wm;
    Switch s;
    BroadcastReceiver br;
    IntentFilter ifr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_demo);
        wm=(WifiManager)(getApplicationContext().getSystemService(WIFI_SERVICE));
        s=findViewById(R.id.w);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    if (!wm.isWifiEnabled())
                    {
                        wm.setWifiEnabled(true);
                    }
                    wm.startScan();
                }
                else
                {
                    if (wm.setWifiEnabled(false));
                }
            }
        });
        ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        br=new WifiBroadCast();
        registerReceiver(br,ifr);
        wm.startScan();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br,ifr);
    }
}