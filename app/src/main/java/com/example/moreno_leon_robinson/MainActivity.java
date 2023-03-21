package com.example.moreno_leon_robinson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<producto> listadoprincipalp;
    private RecyclerView listado_productos;

     private ArrayList<producto> listaprincipalproductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        listado_productos = findViewById(R.id.listado_producto);

        AdaptadorPersonalizado miadaptador = new AdaptadorPersonalizado(listaprincipalproductos);

        miadaptador.setOnClickListener(new AdaptadorPersonalizado.OnClickListener() {
            @Override
            public void OnItemClick(producto miproducto, int posicion) {
                Toast.makeText(MainActivity.this, "Hice click desde el main" +miproducto.getNombre(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemEliminarClick(producto miproducto, int posicion) {
               listaprincipalproductos.remove(posicion);
               miadaptador.setListadoinformacion(listaprincipalproductos);
            }
        });

        listado_productos.setAdapter(miadaptador);
        listado_productos.setLayoutManager(new LinearLayoutManager(this));
    }
    public  void  cargarDatos(){
        producto producto1 = new producto();
        producto1.setNombre("computador hp");
        producto1.setPrecio(500000.0);
        producto1.setUrlimagen("https://image.pngaaa.com/699/1149699-middle.png");

        producto producto2 = new producto();
        producto2.setNombre("Mouse");
        producto2.setPrecio(500000.0);
        producto2.setUrlimagen("https://e7.pngegg.com/pngimages/872/96/png-clipart-computer-mouse-logitech-g203-prodigy-optical-mouse-computer-keyboard-amazon-usb-headset.png");

        producto producto3 = new producto();
        producto3.setNombre("Teclado");
        producto3.setPrecio(500000.0);
        producto3.setUrlimagen("https://img2.freepng.es/20180204/jke/kisspng-computer-keyboard-das-keyboard-switch-usb-numeric-keyboard-png-image-5a77ac2241e081.8561166015177922902698.jpg");


        listaprincipalproductos = new ArrayList<>();
        listaprincipalproductos.add(producto1);
        listaprincipalproductos.add(producto2);
        listaprincipalproductos.add(producto3);

    }
}