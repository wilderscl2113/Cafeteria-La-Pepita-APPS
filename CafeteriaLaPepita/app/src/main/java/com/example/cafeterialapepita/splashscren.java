package com.example.cafeterialapepita;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashscren extends AppCompatActivity {
    TextView textView;
    LottieAnimationView lottieAnimationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscren);
        textView = findViewById(R.id.splashtitulo);
        lottieAnimationView = findViewById(R.id.lottie);

        textView.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottieAnimationView.animate().translationY(2000).setDuration(200).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        }, 5000);
    }
}