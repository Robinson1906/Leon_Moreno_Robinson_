package com.example.moreno_leon_robinson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.moreno_leon_robinson.producto;

public class FormularioActivity extends AppCompatActivity {

    EditText txtNombre,txtPrecio,txtImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtImg=findViewById(R.id.txtImg);
        txtNombre=findViewById(R.id.txtNombre);
        txtPrecio=findViewById(R.id.txtPrecio);

    }
    public void guardar(View view){
        producto p= new producto();
        p.setNombre(txtNombre.getText().toString());
        p.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        p.setUrlimagen(txtImg.getText().toString());


    }
}