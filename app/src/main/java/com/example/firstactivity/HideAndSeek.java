package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.firstactivity.R.id.b1;

public class HideAndSeek extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button b;
    boolean hns=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_and_seek);
        b = findViewById(R.id.b1);
        tv = findViewById(R.id.tv);
        b.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        if (hns)
        {
            hns=false;
            tv.setVisibility(View.VISIBLE);
            b.setText("HIDE MESSAGE");
        }
        else {
            hns=true;
            tv.setVisibility(View.INVISIBLE);
            b.setText("SHOW MESSAGE");
        }
    }
}