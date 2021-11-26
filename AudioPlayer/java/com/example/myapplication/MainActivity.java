package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    Uri uri=null;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

    }
    boolean isStop=true;
    public void btn_play(View view)
    {
        if(uri!=null)
        {
            if(isStop)
            {
                mediaPlayer=MediaPlayer.create(this,uri);
                isStop=false;
            }
            mediaPlayer.start();

            seekSeekbarPosition();
        }

        else
            Toast.makeText(this, "Audio file not found", Toast.LENGTH_SHORT).show();


    }

    public void btn_pause(View view)
    {
        mediaPlayer.pause();
    }

    public void btn_stop(View view)
    {
        mediaPlayer.stop();
        isStop=true;
    }

    public void btn_browse(View view)
    {

        Intent intent =new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        startActivityForResult(intent,101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101 && resultCode==RESULT_OK)
        {
            uri=data.getData();
            isStop=true;
        }


    }

    public void seekSeekbarPosition()
    {
        seekBar.setMax(mediaPlayer.getDuration());
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try
                {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    if(mediaPlayer.getCurrentPosition()<mediaPlayer.getDuration())
                         handler.postDelayed(this,1000);
                }
                catch(Exception ex){}

            }
        };
        handler.postDelayed(runnable,100);
    }


}