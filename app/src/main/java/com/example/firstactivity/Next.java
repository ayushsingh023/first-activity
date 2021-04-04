package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Next extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name=findViewById(R.id.name);
        finish=findViewById(R.id.finish);
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    String n=name.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("name",n);
        setResult(1111,intent);
        finish();
    }
}