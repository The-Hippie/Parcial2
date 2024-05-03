package com.example.adaptaon;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edtUsuario, edtPassword;
    Button btnIniciar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String dataUser = "dataUser";
    public static final int nodo_private = Context.MODE_PRIVATE;

    String dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnIniciar = findViewById(R.id.btnIniciar);

        sharedPreferences = getSharedPreferences(dataUser, nodo_private);
        editor = sharedPreferences.edit();

        dato = getApplicationContext().getSharedPreferences(dataUser, nodo_private).getString("user", "0");

        if (!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        btnIniciar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("user", usuario);
                    editor.commit();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    public void btnIniciar(View view) {
    }
}