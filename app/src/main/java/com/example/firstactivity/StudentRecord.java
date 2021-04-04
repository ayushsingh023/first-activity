package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.firstactivity.model.StudentAdapter;
import com.example.firstactivity.model.StudentHelper;

public class StudentRecord extends AppCompatActivity {
    ListView lv;
    SQLiteDatabase db;
    StudentHelper sh;
    StudentAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);
        lv=findViewById(R.id.lv);
        sh=new StudentHelper(this);
        db=sh.getReadableDatabase();
        Cursor c=sh.getData(db);
        sa=new StudentAdapter(this,c,10);
        lv.setAdapter(sa);

    }
}