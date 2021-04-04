package com.example.firstactivity.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StudentHelper extends SQLiteOpenHelper {
    Context context;
    String query="create table if not exists "+StudentContact.TABLE_NAME +" ( " +
            "" +StudentContact.ID +" int primary key , "+
            "" +StudentContact.NAME +"  varchar(100)   , "+
            "" +StudentContact.ADDRESS +"  varchar(200)  , "+
            "" +StudentContact.AGE +" int , "+
            "" +StudentContact.BRANCH +" varchar(100)  "+
            " ) ";
    public StudentHelper(@Nullable Context context) {
        super(context, StudentContact.DB_NAME,null,StudentContact.VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        Toast.makeText(context, "DATA BASE CREATED", Toast.LENGTH_SHORT).show();
    }
    public long addStudent(SQLiteDatabase db, int id, String name, String address, int branch, String age)
    {
        ContentValues cv=new ContentValues();
        cv.put(StudentContact.ID,id);
        cv.put(StudentContact.NAME,name);
        cv.put(StudentContact.AGE,age);
        cv.put(StudentContact.ADDRESS,address);
        cv.put(StudentContact.BRANCH,branch);
        long r=db.insert(StudentContact.TABLE_NAME,null,cv);
        return r;
    }
    public Cursor getData(SQLiteDatabase db){
        String []column={StudentContact.NAME,StudentContact.ADDRESS,StudentContact.AGE,StudentContact.BRANCH,StudentContact.ID};
        Cursor cursor=db.query(StudentContact.TABLE_NAME,column,null,null,null,null,StudentContact.NAME);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
