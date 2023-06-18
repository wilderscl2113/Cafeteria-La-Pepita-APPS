package com.example.cafeterialapepita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class login extends AppCompatActivity {

    Button buttonIn;
    EditText idnumero,idCorreo;
    TextView linkRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linkRegister = findViewById(R.id.linkRegister);
        buttonIn = findViewById(R.id.buttonIn);
        idnumero = findViewById(R.id.idnumero);
        idCorreo =findViewById(R.id.idCorreo);
        mAuth = FirebaseAuth.getInstance();



        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        buttonIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cedula=idnumero.getText().toString().trim();
                String correo=idCorreo.getText().toString().trim();

                if(cedula.isEmpty()){
                    Toast.makeText(login.this, "Ingresa la cedula", Toast.LENGTH_SHORT).show();
                }else{
                    loginComensal(correo, cedula);
                }


            }


        });

    }
    private void loginComensal(String correo, String cedula ) {
        mAuth.signInWithEmailAndPassword(correo, cedula).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),menu.class));
                    Toast.makeText(login.this, "Inicio exitosamente", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login.this, "Error al iniciar secion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}