package com.example.mypopup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Botonera extends AppCompatActivity {

    static int numBotones = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Establecemos el layout main
        setContentView(R.layout.activity_botonera);

        //Obtenemos el linear layout donde colocar los botones
        LinearLayout llBotonera = (LinearLayout) findViewById(R.id.llBotonera);

        //Creamos las propiedades de layout que tendrán los botones.
        //Son LinearLayout.LayoutParams porque los botones van a estar en un LinearLayout.
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );

        //Creamos los botones en bucle
        for (int i=0; i<numBotones; i++){
            Button button = new Button(this);
            //Asignamos propiedades de layout al boton
            button.setLayoutParams(lp);
            //Asignamos Texto al botón
            button.setText("Boton "+String.format("%02d", i ));
            //Añadimos el botón a la botonera
            llBotonera.addView(button);
        }
    }

    class ButtonsOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Toast.makeText(getApplicationContext(),"Pulsado", Toast.LENGTH_SHORT).show();
        }

    };
}