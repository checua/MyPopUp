package com.example.mypopup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class PopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7), (int) (height*.6));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        final Button button = findViewById(R.id.button2);
        button.setOnClickListener( v -> {
            int n1 = (int) (Math.random()*100);
            if (n1 >= 50) {
                Toast.makeText(getApplicationContext(), "Acertaste", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Fallaste", Toast.LENGTH_SHORT).show();
            }
        } );

        final Button botonera = findViewById(R.id.button);
        botonera.setOnClickListener( v -> {
            Intent i = new Intent(getApplicationContext(), Botonera.class);
            startActivity(i);
        } );


    }
}