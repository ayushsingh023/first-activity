package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
    Button i,d,r;
    TextView count;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        i=findViewById(R.id.inc);
        d=findViewById(R.id.dec);
        r=findViewById(R.id.reset);
        count=findViewById(R.id.count);
        i.setOnClickListener(this);
        d.setOnClickListener(this);
        r.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.inc:
                c++;
                count.setText("COUNT : "+c);
                break;

            case R.id.dec:
                c--;
                count.setText("COUNT : "+c);
                break;

            case R.id.reset:
                c=0;
                count.setText("COUNT : "+c);
                break;
        }
    }
}