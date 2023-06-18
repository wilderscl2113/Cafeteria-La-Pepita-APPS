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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button jbtn1,jbtnR,jbtnL;
    EditText jmesa;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        jbtn1=findViewById(R.id.btn1);
        //jmesa=findViewById(R.id.mesa);
        jbtnR=findViewById(R.id.btnR);
        jbtnL=findViewById(R.id.btnL);

        jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginAnonimus();
            /*Bundle enviaDatos = new Bundle();
            enviaDatos.putString("keydatos",jmesa.getText().toString());
                Intent intent=new Intent(MainActivity.this,menu.class);
                intent.putExtras(enviaDatos);
                startActivity(intent);*/

            }



        });

        jbtnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentR = new Intent(MainActivity.this,Register.class);
                startActivity(intentR);
            }
        });

        jbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentL = new Intent(MainActivity.this,login.class);
                startActivity(intentL);
            }
        });




    }
    private void loginAnonimus() {
    mAuth.signInAnonymously()
            .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();
                        startActivity(new Intent(getApplicationContext(),menu.class));
                        Toast.makeText(MainActivity.this, "Ingreso exitosamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Error al ingresar", Toast.LENGTH_SHORT).show();
                }
            });

    }
}