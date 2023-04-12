package com.example.moreno_leon_robinson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_correo,et_contraseña;
    private Button Login;
    private SharedPreferences mispreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        referenciar();

        mispreferencias = getSharedPreferences("tienda_app",MODE_PRIVATE);

        //verificar si esta logueado

        if(mispreferencias.getBoolean("logueado",false)){
            Intent miIntent = new Intent(this,MainActivity.class);
            startActivity(miIntent);
            finish();
        }
    }

    private void referenciar() {
        et_contraseña = findViewById(R.id.et_contraseña);
        et_correo = findViewById(R.id.et_correo);
        Login = findViewById(R.id.Login);
    }
    public void  clickIniciarSesion(View view){
        String PASS = "12345";
        String USER = "fabian";
        String passer = et_contraseña.getText().toString();
        String userUser= et_correo.getText().toString();

        if(PASS.equals(passer)&&USER.equals(userUser)){

            SharedPreferences.Editor mieditor =  mispreferencias.edit();
            mieditor.putBoolean("logueado",true);
            mieditor.apply();

            Intent miIntent = new Intent(this,MainActivity.class);
            startActivity(miIntent);
            finish();
        }else {
            Toast.makeText(this, "credenciales incorrectas", Toast.LENGTH_SHORT).show();

        }
    }
}

