package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PrefrenceFromXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_from_x_m_l);
        addPreferencesFromResource(R.xml.mypref);
    }

    private void addPreferencesFromResource(int mypref) {
    }

}