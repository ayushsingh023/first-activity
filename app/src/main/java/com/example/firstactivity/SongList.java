package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView songlist;
    ArrayList<String> song=new ArrayList<String>();
    ArrayList<String> data=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        songlist=findViewById(R.id.songlist);
        c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        while (c.moveToNext())
        {
            song.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE)));
            data.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA)));
        }
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,song );
        songlist.setAdapter(adapter);
        songlist.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(SongList.this,Music.class);
        intent.putExtra("song",song.get(position));
        intent.putExtra("data",song.get(position));
        startActivity(intent);
    }
}