package com.example.multimedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class cancion3 extends AppCompatActivity {

    private ImageButton btn_play, btn_pause, btn_stop;
    int estado= 0 ;
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion3);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        btn_play= (ImageButton)findViewById(R.id.plays);
        btn_pause= (ImageButton)findViewById(R.id.pauses);
        btn_stop= (ImageButton)findViewById(R.id.stops);
        mediaplayer = MediaPlayer.create(this, R.raw.cancion3);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer.start();
                estado = 1;
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (estado == 1){
                    mediaplayer.pause();
                    estado ++;
                }
                else if (estado == 2){
                    mediaplayer.start();
                    estado = 1;
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
                try{
                    mediaplayer.stop();
                    mediaplayer.prepare();
                    mediaplayer.seekTo(0);
                    estado = 0;
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void irMusica (View view){
        Intent ii = new Intent(this, MainActivity3.class);
        startActivity(ii);
        mediaplayer.stop();
    }
}
