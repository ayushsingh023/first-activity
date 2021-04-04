package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstactivity.model.StudentHelper;

public class RegisterStudent extends AppCompatActivity implements View.OnClickListener {

    EditText id,name,add,age,branch;
    Button register;
    StudentHelper sh;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        id=findViewById(R.id.sid);
        name=findViewById(R.id.sname);
        add=findViewById(R.id.sadd);
        age=findViewById(R.id.sage);
        branch=findViewById(R.id.sbranch);
        register=findViewById(R.id.register);
        sh=new StudentHelper(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db=sh.getWritableDatabase();
        int sid= Integer.parseInt(id.getText().toString());
        int sage= Integer.parseInt(age.getText().toString());
        String sname=name.getText().toString();
        String sadd=add.getText().toString();
        String sbranch=branch.getText().toString();
        sh.addStudent(db,sid,sname,sbranch,sage,sadd);
        Toast.makeText(this, "Data Inserted !!!", Toast.LENGTH_SHORT).show();
    }
}