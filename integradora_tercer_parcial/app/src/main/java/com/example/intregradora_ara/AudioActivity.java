package com.example.intregradora_ara;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {
    //Objetos
    private Button btnPlay, btnSP, btnStop;
    private MediaPlayer media;
    private int estado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        //Enlace de objetos
        btnPlay = findViewById(R.id.Play);
        btnSP = findViewById(R.id.StartPause);
        btnStop = findViewById(R.id.Stop);
        //Preparacion del tono
        media = MediaPlayer.create(this, R.raw.cancion);
        //Eventos onClick
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.start();
                estado = 1;
                btnSP.setText("Pausa");
            }
        });
        btnSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estado == 1) {
                    media.pause();
                    btnSP.setText("Start");
                    estado = 2;
                }
                else if(estado == 2) {
                    media.start();
                    btnSP.setText("Pausa");
                    estado = 1;
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    media.stop();
                    media.prepare();
                    media.seekTo(0);
                    estado = 0;
                    btnSP.setText("Pausa");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
