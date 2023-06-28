package com.example.multimedia;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        mediaplay = MediaPlayer.create(this, R.raw.audioinicio);
        mediaplay.start();
    }
    public void irCamara (View view){
        Intent iii = new Intent(this, Camara.class);
        startActivity(iii);
    }
    public void irVideos (View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
    public void irMusica (View view){
        Intent ii = new Intent(this, MainActivity3.class);
        startActivity(ii);
    }
}