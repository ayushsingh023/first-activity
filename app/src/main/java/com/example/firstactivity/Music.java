package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class Music extends AppCompatActivity implements View.OnClickListener , SeekBar.OnSeekBarChangeListener {
    TextView cdur,rdur,songname;
    SeekBar progress;
    ImageButton play;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        cdur=findViewById(R.id.cdur);
        rdur=findViewById(R.id.rdur);
        songname=findViewById(R.id.songname);
        progress=findViewById(R.id.progress);
        play=findViewById(R.id.play);
        Bundle b=getIntent().getExtras();
        songname.setText(b.getString("song"));
        mp= MediaPlayer.create(this, Uri.parse(b.getString("data")));
        rdur.setText(convertToDuration(mp.getDuration()));
        progress.setMax(mp.getDuration());
        play.setOnClickListener(this);
        progress.setOnSeekBarChangeListener(this);
        new Thread(){
            @Override
            public void run(){
                while (mp.getCurrentPosition()!=mp.getDuration())
                {
                    progress.setProgress(mp.getCurrentPosition());
                }
            }
        }.start();
    }

    public String convertToDuration(long d) {
        String dur="";
        d=d/1000;
        dur=dur+d/60+":"+d%60;
        return dur;
    }

    @Override
    public void onClick(View v) {
        if (!mp.isPlaying())
        {
            mp.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser)
        {
            mp.seekTo(progress);
        }
        cdur.setText(convertToDuration(mp.getCurrentPosition()));
        rdur.setText(convertToDuration(mp.getDuration()-mp.getCurrentPosition()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}