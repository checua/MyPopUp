package com.example.mypopup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_sub;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_sub = (Button) findViewById(R.id.btn_sub);
        imageView = findViewById(R.id.imageView2);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopActivity.class);
                startActivity(i);


            }
        });


        imageView.setOnClickListener ( v -> {
            // Intent class will help to go to next activity using
            // it's object named intent.
            // SecondActivty is the name of new created EmptyActivity.
            int n1 = (int) (Math.random()*100);
            if (n1 >= 50) {
                Toast.makeText(getApplicationContext(), "Acertaste", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Fallaste", Toast.LENGTH_SHORT).show();
            }
        });


    }
}