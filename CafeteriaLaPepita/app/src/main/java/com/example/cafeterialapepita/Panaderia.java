package com.example.cafeterialapepita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Panaderia extends AppCompatActivity {

    TextView jmesar2;

    private ImageButton jimgbtnC, jimgbtnA, jimgbtnB,jbtnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panaderia);

        jbtnback =findViewById(R.id.btnback);
        jmesar2 = findViewById(R.id.mesar2);
        jimgbtnC = findViewById(R.id.imgbtnC);
        jimgbtnA = findViewById(R.id.imgbtnA);
        jimgbtnB = findViewById(R.id.imgbtnB);

        jimgbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Panaderia.this, PupApp.class));

            }
        });

        jimgbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Panaderia.this, PopUp.class));

            }
        });

        jimgbtnB.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Panaderia.this, PopUp2.class));
            }
        }));

        jbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), menu.class);
                startActivity(intent1);
            }
        });

       /* jbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), menu.class);
                startActivity(intent1);

            }
        });*/

        //Bundle recibeDatos1 = getIntent().getExtras();

        //String info1 = recibeDatos1.getString("keydatos");
    }
}