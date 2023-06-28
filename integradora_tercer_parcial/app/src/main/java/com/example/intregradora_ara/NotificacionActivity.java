package com.example.intregradora_ara;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificacionActivity extends AppCompatActivity {
    //Objetos
    private Button btnNoti;
    public NotificationCompat.Builder notificacion;
    public final int idUnica = 18472;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        //Enlace de objetos
        btnNoti = findViewById(R.id.Noti);
        //Inicio de la notificacion
        notificacion = new NotificationCompat.Builder(this);
        notificacion.setAutoCancel(true);
        //Eventos onClick
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Notificacion");
                notificacion.setPriority(Notification.PRIORITY_HIGH);
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("Proyecto Integrador");
                notificacion.setContentText("Notificacion de la actividad integradora");

                Intent intent = new Intent(NotificacionActivity.this, NotificacionActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificacionActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(idUnica, notificacion.build());
            }
        });
    }
}
