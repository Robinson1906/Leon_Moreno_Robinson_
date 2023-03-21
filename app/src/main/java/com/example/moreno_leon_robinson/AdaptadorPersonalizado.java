package com.example.moreno_leon_robinson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends  RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    public void setListadoinformacion(ArrayList<producto> listadoinformacion) {
        this.listadoinformacion = listadoinformacion;
        notifyDataSetChanged();
    }

    private ArrayList<producto> listadoinformacion;

    private OnClickListener onClickListener;

    public AdaptadorPersonalizado(ArrayList<producto> listadoinformacion) {
        this.listadoinformacion = listadoinformacion;
        this.onClickListener = null;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View miview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_productos,parent,false);
        return new ViewHolder(miview);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {

        producto miproducto = listadoinformacion.get(position);
        holder.enlazar(miproducto);

    }

    @Override
    public int getItemCount() {
        return listadoinformacion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre,precio;
        private ImageView producto;
        private Button Eliminar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.item_nombre);
            precio = itemView.findViewById(R.id.item_precio);
            producto = itemView.findViewById(R.id.item_img);
            Eliminar = itemView.findViewById(R.id.item_eliminar);
        }
        public  void  enlazar(producto miproducto){
            nombre.setText(miproducto.getNombre());
            precio.setText(miproducto.getPrecio().toString());
            Picasso.get().load(miproducto.getUrlimagen())
                    .error(R.drawable.ic_launcher_background)
                    .into(producto);

            if (onClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       onClickListener.OnItemClick(miproducto,getAdapterPosition());
                    }
                });
                Eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.OnItemEliminarClick(miproducto,getAdapterPosition());
                    }
                });
            }
        }

    }
    public interface OnClickListener{
        void OnItemClick(producto miproducto,int posicion);
        void OnItemEliminarClick(producto miproducto,int posicion);

    }
}