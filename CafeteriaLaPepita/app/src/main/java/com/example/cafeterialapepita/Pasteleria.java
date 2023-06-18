package com.example.cafeterialapepita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pasteleria extends AppCompatActivity {

    TextView jmesar2;

    private ImageButton jimgbtnC, jimgbtnA, jimgbtnB,jbtnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasteleria);

        jbtnback =findViewById(R.id.btnback);
        jmesar2 = findViewById(R.id.mesar2);
        jimgbtnC = findViewById(R.id.imgbtnC);
        jimgbtnA = findViewById(R.id.imgbtnA);
        jimgbtnB = findViewById(R.id.imgbtnB);

        jimgbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Pasteleria.this, popup3_1.class));

            }
        });

        jimgbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Pasteleria.this, PopUp3_2.class));

            }
        });

        jimgbtnB.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Pasteleria.this, PopUp3_3.class));
            }
        }));
        jbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp = new Intent(Pasteleria.this,menu.class);
                startActivity(intentp);
            }
        });

    }
}