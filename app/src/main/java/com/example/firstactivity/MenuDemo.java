package com.example.firstactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuDemo extends AppCompatActivity {

    String name[]={"Abhishek","Anurag","Saurav","Rahul","Kuldeep","Naman","Rohan","Sachin",
            "Santhosh","Pradeep","Rohit","Raman"};
    ListView lv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        lv=findViewById(R.id.lv);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name );
        lv.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("What You Want to do?");
        menu.add(0,v.getId(),0,"SMS");
        menu.add(0,v.getId(),0,"MMS");
        menu.add(0,v.getId(),0,"CALL");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "You Clicked On"+item.getTitle(), Toast.LENGTH_SHORT).show();
        return false;
    }
}