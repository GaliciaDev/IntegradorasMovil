//Videos
package com.example.multimedia;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }
    public void irInicio (View view){
        Intent iii = new Intent(this, MainActivity.class);
        startActivity(iii);
    }
    public void irVideo1 (View view){
        Intent a = new Intent(this, video1.class);
        startActivity(a);
    }
    public void irVideo2 (View view){
        Intent b = new Intent(this, video2.class);
        startActivity(b);
    }
    public void irVideo3 (View view){
        Intent c = new Intent(this, video3.class);
        startActivity(c);
    }
}