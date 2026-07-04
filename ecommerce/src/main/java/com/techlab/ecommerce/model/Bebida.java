package com.techlab.ecommerce.model;

public class Bebida extends Producto {

    private String tamanio;

    public Bebida() {
    }

    public Bebida(String nombre, String categoria, double precio, int stock, String tamanio) {
        super(nombre, categoria, precio, stock);
        this.tamanio = tamanio;
    }

    public Bebida(int id, String nombre, double precio, int stock, String tamanio) {
        super(id, nombre, precio, stock);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tamanio: " + tamanio;
    }
}
