package com.example.integradora_primer_parcial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Variables
    private static final String FILE_NAME = "Mi_Archivo.txt";
    public static String CHANNEL_ID = "NOTIFICACION";
    String Mensaje;
    //Objetos
    Button guardar, limpiar, lanzar_toast, notificacion;
    EditText txt_Texto;

    public static final int idUnica = 20100107;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        guardar = findViewById(R.id.btn_Guardar);
        limpiar = findViewById(R.id.btn_Limpiar);
        lanzar_toast = findViewById(R.id.btn_Toast);
        notificacion = findViewById(R.id.btn_Notificacion);

        guardar.setOnClickListener((View.OnClickListener) this);
        limpiar.setOnClickListener((View.OnClickListener) this);
        lanzar_toast.setOnClickListener((View.OnClickListener) this);
        notificacion.setOnClickListener((View.OnClickListener) this);

        lanzar_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "leo", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {canalDeNotificacion();}
        });
    }

    //Leer de Mi_Archivo.txt
    public void leer() {
        //Variables
        FileInputStream fileInputStream = null;
        String linea;
        StringBuilder texto = new StringBuilder();
        try {
            fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((linea = bufferedReader.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            Mensaje = texto.toString();
        } catch(Exception e) {
            Toast.makeText(this, "No Se Pudo Leer El Archivo", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    Toast.makeText(this, "No Se Pudo Cerrar El Archivo", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }
    }

    private void crearCanalNotificacion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence nombre = "Notificacion";
            NotificationChannel nCh = new NotificationChannel(CHANNEL_ID, nombre, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(nCh);
        }
    }

    private void canalDeNotificacion(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.miamosnter);
        builder.setContentTitle("leo");
        builder.setContentText(Mensaje);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat nm = NotificationManagerCompat.from(getApplicationContext());
        nm.notify(idUnica, builder.build());
    }
    //Escribir en Mi_Archivo.txt
    public void escribir(){
        String saveText = txt_Texto.getText().toString();
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(saveText.getBytes());
            Toast.makeText(this, "Texto Guardado", Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(this, "Archivo No Guardado", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (Exception e){
                    Toast.makeText(this, "No Se Pudo Cerrar", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_Guardar:
                escribir();
                break;
            case R.id.btn_Limpiar:
                txt_Texto.setText("");
                break;
            case R.id.btn_Notificacion:
                leer();
                break;
            case R.id.btn_Toast:
                leer();
                Toast.makeText(this, Mensaje, Toast.LENGTH_LONG).show();
                break;
        }
    }
}