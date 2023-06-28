package com.example.intregradora_ara;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    //Objetos
    private Button btnPlay, btnSP, btnStop;
    private VideoView video;
    private int estado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //Enlace de objetos
        btnPlay = findViewById(R.id.Play);
        btnSP = findViewById(R.id.StartPause);
        btnStop = findViewById(R.id.Stop);
        video = findViewById(R.id.Video);
        //Preparacion del video
        String path = "android.resource://" + getPackageName() + "/" + R.raw.pelicula;
        video.setVideoURI(Uri.parse(path));
        //Eventos onClick
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.start();
                estado = 1;
                btnSP.setText("Pausa");
            }
        });
        btnSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estado == 1) {
                    video.pause();
                    btnSP.setText("Start");
                    estado = 2;
                }
                else if(estado == 2) {
                    video.start();
                    btnSP.setText("Pausa");
                    estado = 1;
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.stopPlayback();
                video.resume();
                video.seekTo(0);
                btnSP.setText("Pausa");
            }
        });
    }
}
