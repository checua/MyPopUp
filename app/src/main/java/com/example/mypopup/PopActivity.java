package com.example.mypopup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
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

        final Button dynamicBtn = findViewById(R.id.button3);
        dynamicBtn.setOnClickListener( v -> {
           // Toast.makeText(getApplicationContext(), "Dynamic", Toast.LENGTH_SHORT).show();

            //Button buttonx = new Button(this);

            //Establecemos el layout main
            setContentView(R.layout.activity_pop);

            //Obtenemos el linear layout donde colocar los botones
            LinearLayout ll3btns = (LinearLayout) findViewById(R.id.ll3btns);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );



            for (int i = 0; i< 1; i++){
                Button btn = new Button(this);
                //Asignamos propiedades de layout al boton
                btn.setLayoutParams(lp);
                //Asignamos Texto al botón
                btn.setText("Boton "+String.format("%02d", i ));
                btn.setOnClickListener(new ButtonsOnClickListener (this,i));

                //Añadimos el botón a la botonera
                ll3btns.addView(button);
            }

        } );


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