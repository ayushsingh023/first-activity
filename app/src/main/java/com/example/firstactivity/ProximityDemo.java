package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityDemo extends AppCompatActivity {

    SensorManager sm;
    Sensor s;
    TextView tv;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            if (s.getMaximumRange()<x)
            {
                tv.setText("NEAR");
            }
            else
            {
                tv.setText("FAR");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_demo);
        sm=(SensorManager)(getSystemService(SENSOR_SERVICE));
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        tv=findViewById(R.id.list);
    }
}