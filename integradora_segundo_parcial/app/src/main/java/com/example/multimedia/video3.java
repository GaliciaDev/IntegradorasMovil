package com.example.multimedia;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
public class video3 extends AppCompatActivity {
    private ImageButton btnplay, btnpause, btnstop;
    int estado = 0;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video3);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        video = (VideoView) findViewById(R.id.video3);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.pelicula3;
        video.setVideoURI(Uri.parse(path));
        btnplay = (ImageButton) findViewById(R.id.plays);
        btnpause = (ImageButton) findViewById(R.id.pauses);
        btnstop = (ImageButton) findViewById(R.id.stops);
        btnplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                video.start();
                estado = 1;
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("setTextI18")
            @Override
            public void onClick(View view){
                video.stopPlayback();
                video.resume();
                video.seekTo(0);
                estado = 0;
            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("setTextI18")
            @Override
            public void onClick(View view){
                if (estado == 1){
                    video.pause();
                    estado++;
                } else if (estado == 2){
                    video.start();
                    estado = 1;
                }
            }
        });
    }
    public void irVideos (View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}