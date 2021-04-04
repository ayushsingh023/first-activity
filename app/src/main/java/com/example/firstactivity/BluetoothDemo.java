package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.firstactivity.model.BluetoothBroadCast;

public class BluetoothDemo extends AppCompatActivity {
    Switch s;
    BluetoothAdapter ba;
    BroadcastReceiver br;
    IntentFilter ifr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_demo);
        s=findViewById(R.id.b);
        ba=BluetoothAdapter.getDefaultAdapter();
        if (ba!=null)
        {
            s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                    {
                        if (!ba.isEnabled())
                        {
                            Toast.makeText(BluetoothDemo.this, "TURNING ON...", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        }
                    }
                    else
                    {
                        if (ba.isEnabled())
                        {
                            ba.disable();
                        }
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "No Bluetooth Hardware", Toast.LENGTH_SHORT).show();
        }
        ifr=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        br=new BluetoothBroadCast();
        ba.startDiscovery();
        registerReceiver(br,ifr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ba.startDiscovery();
    }
}
