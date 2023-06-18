package com.example.cafeterialapepita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;



import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {



    EditText editTextNombre,editTextNumero,editTextCorreo;

    Button btnRegister;
    private  FirebaseFirestore mfirestore;
    FirebaseAuth mAuth;

    //String nombre,numeroCedula,correo,id, coleccion="Comensales";
    //FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mfirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextNumero = findViewById(R.id.editTextNumero);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        btnRegister =findViewById(R.id.btnRegister);

    btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = editTextNombre.getText().toString().trim();
            String cedula = editTextNumero.getText().toString().trim();
            String correo = editTextCorreo.getText().toString().trim();

            if(nombre.isEmpty() && cedula.isEmpty() && correo.isEmpty()){
                Toast.makeText(Register.this, "Ingresar los datos", Toast.LENGTH_SHORT).show();
            }else{
                postUsuario(nombre,cedula,correo);
            }

        }

    });

    }
    private void postUsuario(String nombre, String cedula, String correo) {

        mAuth.createUserWithEmailAndPassword(correo,cedula).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map <String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("Nombre", nombre);
                map.put("Cedula",cedula);
                map.put("Correo",correo);

                mfirestore.collection("Comensal").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Register.this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(),menu.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        })




    /*mfirestore.collection("usuario").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
        @Override
        public void onSuccess(DocumentReference documentReference) {
            Toast.makeText(Register.this, "Creado exitosamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),menu.class));
        }
    })*/.addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(Register.this, "Error al ingresar", Toast.LENGTH_SHORT).show();
        }
    });


    }





}