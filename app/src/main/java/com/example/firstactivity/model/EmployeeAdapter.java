package com.example.firstactivity.model;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstactivity.R;
import com.squareup.picasso.Picasso;

public class EmployeeAdapter extends RecyclerView.ViewHolder {
    View v;
    public EmployeeAdapter(@NonNull View itemView) {
        super(itemView);
        v=itemView;
    }
    public void setView(Context context,Employee emp)
    {
        TextView id,name,bg,add,age;
        ImageView profilepic;
        id=v.findViewById(R.id.eid);
        add=v.findViewById(R.id.eadd);
        name=v.findViewById(R.id.ename);
        age=v.findViewById(R.id.eage);
        bg=v.findViewById(R.id.ebg);
        profilepic=v.findViewById(R.id.pic);
        id.setText(String.valueOf(emp.getId()));
        age.setText(String.valueOf(emp.getAge()));
        add.setText(emp.getAdd());
        name.setText(emp.getName());
        bg.setText(emp.getBloodgroup());
        Picasso.get().load(emp.getImageurl()).into(profilepic);
    }
}
