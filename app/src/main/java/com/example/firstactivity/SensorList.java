package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {
    TextView tv;
    SensorManager sm;
    List<Sensor> ls;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tv=findViewById(R.id.list);
        sm=(SensorManager)(getSystemService(SENSOR_SERVICE));
        ls=sm.getSensorList(Sensor.TYPE_ALL);
        sb=new StringBuilder();
        for (Sensor s:ls) {
            sb.append(s.getName() + "||" + s.getVendor() + "||" + s.getType() + "\n");
        }
        tv.setText(sb.toString());
    }
}