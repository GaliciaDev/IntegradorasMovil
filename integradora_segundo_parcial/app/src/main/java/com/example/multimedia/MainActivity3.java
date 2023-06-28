//Canciones
package com.example.multimedia;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }
    public void irInicio (View view){
        Intent iii = new Intent(this, MainActivity.class);
        startActivity(iii);
    }
    public void irCancion1 (View view){
        Intent a = new Intent(this, Cancion.class);
        startActivity(a);
    }
    public void irCancion2 (View view){
        Intent b = new Intent(this, cancion2.class);
        startActivity(b);
    }
    public void irCancion3 (View view){
        Intent c = new Intent(this, cancion3.class);
        startActivity(c);
    }
}