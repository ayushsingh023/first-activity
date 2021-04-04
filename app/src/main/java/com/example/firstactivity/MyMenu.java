              package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MyMenu extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] activity = {"EmployeeRecord","EmployeeRegistration","MapsActivity","WifiDemo","BluetoothDemo","SongList","WebViewDemo","FileDemo",
            "StudentRecord","RegisterStudent","PrefrenceFromXML","MainActivity2","TicTacToe",
            "ProximityDemo","AccSensor","SensorList","MenuDemo","Previous","SendData","Quiz",
            "SpinnerActivity","ColourPicker","ActivityLifeCycle","FirstActivity","CounterActivity",
            "HideAndSeek","MathsOperation"};
    ListView lv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menu);
        lv=findViewById(R.id.lv);
        //adapter=new ArrayAdapter<String>(this, R.layout.custom_list_design,R.id.tv,activity);
        adapter=new ArrayAdapter<String>(this,R.layout.custom_list_design,R.id.tv,activity);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try{
            String s="com.example.firstactivity."+activity[position];
            Class c=Class.forName(s);
            Intent intent=new Intent(MyMenu.this,c);
            startActivity(intent);
        }catch (Exception e)
            {
            }
    }
}