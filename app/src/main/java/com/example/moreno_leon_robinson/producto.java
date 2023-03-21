package com.example.moreno_leon_robinson;

public class producto {
    private  String nombre;
    private  Double precio;
    private  String urlimagen;

    public  producto(){}

    public producto(String nombre, Double precio, String urlimagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.urlimagen = urlimagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
