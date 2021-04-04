package com.example.firstactivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity implements View.OnClickListener {
    Button popup;
    PopupMenu popupMenu;
    SharedPreferences sp;
    LinearLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        popup=findViewById(R.id.popup);
        layout=findViewById(R.id.layout);
        popup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        popupMenu=new PopupMenu(this,popup);
        popupMenu.getMenuInflater().inflate(R.menu.mymenu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                popup.setText(item.getTitle().toString());
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setBackGround();
    }
    void setBackGround()
    {
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, ""+sp.getBoolean("update",false), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+sp.getString("device","ONEPLUS"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+sp.getString("bgcolor", "1"), Toast.LENGTH_SHORT).show();
        switch (sp.getString("bgcolor","1"))
        {
            case "1":
                layout.setBackgroundColor(Color.WHITE);
                break;
            case "2":
                layout.setBackgroundColor(Color.RED);
                break;
            case "3":
                layout.setBackgroundColor(Color.GREEN);
                break;
            case "4":
                layout.setBackgroundColor(Color.BLUE);
                break;
            case "5":
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case "6":
                layout.setBackgroundColor(Color.GRAY);
                break;
            default:
                layout.setBackgroundColor(Color.WHITE);
        }
    }
}
