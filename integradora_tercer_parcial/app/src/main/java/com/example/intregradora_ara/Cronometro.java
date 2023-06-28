package com.example.intregradora_ara;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends Service {
    //Objetos
    private Timer temporizador = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 10;
    public static SegundoPlanoActivity UPDATE_LISTENER;
    private double cronometro = 0;
    private Handler handler;
    //Actualizar el servicio
    public static void setUpdateListener(SegundoPlanoActivity main) {
        UPDATE_LISTENER = main;
    }
    //Actualizar el cronometro
    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate() {
        super.onCreate();
        iniciarCrono();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                UPDATE_LISTENER.actualizarCrono(cronometro);
            }
        };
    }
    //Evento onDestroy
    @Override
    public void onDestroy() {
        detenerCrono();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg) {
        return null;
    }
    //Evento para inciar el cronometro
    private void iniciarCrono() {
        temporizador.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cronometro += 0.01;
                handler.sendEmptyMessage(0);
            }
        }, 0, INTERVALO_ACTUALIZACION);
    }
    //Evento para detener el cronometro
    private void detenerCrono() {
        if (temporizador !=  null) {
            temporizador.cancel();
        }
    }
}
