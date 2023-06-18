package com.example.cafeterialapepita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class menu extends AppCompatActivity {

            TextView jmesar1;
            ImageButton jimgbtnback, jimgbtn1, jimgbtn2, jimgbtn3, jimgbtn4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        jmesar1 = findViewById(R.id.mesar1);
        jimgbtnback = findViewById(R.id.btnback);
        jimgbtn1 = findViewById(R.id.imgbtn1);
        jimgbtn2 = findViewById(R.id.imgbtn2);
        jimgbtn3 = findViewById(R.id.imgbtn3);
        jimgbtn4 = findViewById(R.id.imgbtn4);

        jimgbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);

            }
        });

        jimgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Panaderia.class);
                startActivity(intent2);
            }
        });

        //Bundle recibeDatos = getIntent().getExtras();

        //String info = recibeDatos.getString("keydatos");

        //jmesar1.setText(info);

        jimgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Cafeteria.class);
                startActivity(intent2);
            }
        });

        jimgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Pasteleria.class);
                startActivity(intent2);
            }
        });

        jimgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Especiales.class);
                startActivity(intent2);
            }
        });

    }
}