package com.techlab.ecommerce.model;

//Clase Producto: con atributos id, nombre, precio, stock, getters y setters.

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

        public int getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}