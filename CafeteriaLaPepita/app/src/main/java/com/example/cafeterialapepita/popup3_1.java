package com.example.cafeterialapepita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class popup3_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup31);

        DisplayMetrics medidasvetana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasvetana);

        int ancho = medidasvetana.widthPixels;
        int alto = medidasvetana.widthPixels;

        getWindow().setLayout((int)(ancho * 0.9), (int)(alto * 1.5));
    }
}