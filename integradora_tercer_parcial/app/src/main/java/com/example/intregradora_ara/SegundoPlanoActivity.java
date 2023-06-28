package com.example.intregradora_ara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundoPlanoActivity extends Activity {
    //Objetos
    private TextView txtCrono;
    private Button btnInicia, btnDetener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_plano);
        //Enlace de objetos y eventos
        txtCrono = (TextView) findViewById(R.id.Cronometro);
        btnInicia = (Button) findViewById(R.id.Iniciar);
        btnDetener = (Button) findViewById(R.id.Detener);
        //Eventos onClick
        btnInicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarCrono();
            }
        });
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detenerCrono();
            }
        });
        //Llamada a la clase Cronometro
        Cronometro.setUpdateListener(this);
    }
    //Evento onDestroy
    @Override
    protected void onDestroy() {
        detenerCrono();
        super.onDestroy();
    }
    //Evento para iniciar el servicio
    private void iniciarCrono() {
        Intent servicio = new Intent(this, Cronometro.class);
        startService(servicio);
    }
    //Evento para detener el servicio
    private void detenerCrono() {
        Intent servicio = new Intent(this, Cronometro.class);
        stopService(servicio);
    }
    //Actualización del cronometro
    public void actualizarCrono(double tiempo) {
        txtCrono.setText(String.format("%.2f", tiempo) + " s");
    }
}
