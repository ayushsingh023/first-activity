package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    Spinner sp;
    ConstraintLayout cl;
    String name []={"ABHISHEK","RAHUL","ANURAG","ABHAY","RAJESH","RITIK",
    "MAYANK","SACHIN","SURESH","NAMAN","NAMITA"};
    ArrayAdapter<String> adapter;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        cl=findViewById(R.id.cl);
        actv=findViewById(R.id.actv);
        mactv=findViewById(R.id.mactv);
        sp=findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mactv.setThreshold(1);
        actv.setThreshold(1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (sp.getSelectedItem().toString())
        {
            case "Default" :
                cl.setBackgroundColor(Color.WHITE);
                break;
            case "Red" :
                cl.setBackgroundColor(Color.RED);
                break;
            case "Blue" :
                cl.setBackgroundColor(Color.BLUE);
                break;
            case "Green" :
                cl.setBackgroundColor(Color.GREEN);
                break;
            case "Yellow" :
                cl.setBackgroundColor(Color.YELLOW);
                break;
            case "Gray" :
                cl.setBackgroundColor(Color.GRAY);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}