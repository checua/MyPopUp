package com.example.mypopup;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Botonera extends AppCompatActivity {

    static int nunBones = 20;

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
        for (int i = 0; i< nunBones; i++){
            Button button = new Button(this);
            //Asignamos propiedades de layout al boton
            button.setLayoutParams(lp);
            //Asignamos Texto al botón
            button.setText("Boton "+String.format("%02d", i ));
            button.setOnClickListener(new ButtonsOnClickListener(this,i));

            //Añadimos el botón a la botonera
            llBotonera.addView(button);
        }
    }

    class ButtonsOnClickListener implements View.OnClickListener
    {
        Context context;
        int numButton;

        public ButtonsOnClickListener(Context context, int numButton) {
            this.context = context;
            this.numButton = numButton;
        }

        @Override
        public void onClick(View v)
        {
            String mensaje="";
            if (numButton%2==0)
                mensaje="Boton PAR "+String.format("%02d", numButton );
            else
                mensaje="Boton IMPAR "+String.format("%02d", numButton );

            Toast.makeText(this.context,mensaje,Toast.LENGTH_SHORT).show();


        }

    };
}