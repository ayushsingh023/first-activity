package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendData extends AppCompatActivity implements View.OnClickListener {
    EditText name,address;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        send=findViewById(R.id.senddata);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String n=name.getText().toString();
        String add=address.getText().toString();
        Intent intent=new Intent(SendData.this,GetData.class);
        intent.putExtra("name",n);
        intent.putExtra("add",add);
        startActivity(intent);
    }
}