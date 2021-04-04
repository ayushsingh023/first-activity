package com.example.firstactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Previous extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        tv=findViewById(R.id.name);
        next=findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Previous.this,Next.class);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==1000 && requestCode==1111 && data!=null){
            Bundle b=data.getExtras();
            tv.setText(b.getString("name"));
        }
    }

}