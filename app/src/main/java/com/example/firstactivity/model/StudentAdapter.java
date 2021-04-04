package com.example.firstactivity.model;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.firstactivity.R;

public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c, int flags) {

        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_student_view,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id,name,add,branch,age;
        id=view.findViewById(R.id.sid);
        name=view.findViewById(R.id.sname);
        add=view.findViewById(R.id.sadd);
        branch=view.findViewById(R.id.sbranch);
        age=view.findViewById(R.id.sage);
        id.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(StudentContact.ID))));
        age.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(StudentContact.AGE))));
        branch.setText(String.valueOf(cursor.getString(cursor.getColumnIndex(StudentContact.BRANCH))));
        add.setText(String.valueOf(cursor.getString(cursor.getColumnIndex(StudentContact.ADDRESS))));
        name.setText(String.valueOf(cursor.getString(cursor.getColumnIndex(StudentContact.NAME))));
    }
}
