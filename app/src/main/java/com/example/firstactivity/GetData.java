package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GetData extends AppCompatActivity {
    TextView name,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        name=findViewById(R.id.name);
        add=findViewById(R.id.address);
        Bundle db=getIntent().getExtras();
        name.setText(db.getString("name"));
        add.setText(db.getString("add"));
    }
}