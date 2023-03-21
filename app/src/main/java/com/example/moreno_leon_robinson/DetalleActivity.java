package com.example.moreno_leon_robinson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView tv_titulo,tv_precio;
    private ImageView iv_imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getString(R.string.detalle));

        tv_titulo=findViewById(R.id.txtTitulo);
        tv_precio=findViewById(R.id.txtPrecio);
        iv_imagen=findViewById(R.id.imgDetalle);

        producto miproducto= (producto) getIntent().getSerializableExtra("producto");

        tv_precio.setText(miproducto.getPrecio().toString());
        tv_titulo.setText(miproducto.getNombre());
        Picasso.get().load(miproducto.getUrlimagen())
            .error(R.drawable.ic_launcher_background)
                .into(iv_imagen);
    }
}