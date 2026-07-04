package com.techlab.ecommerce.model;

public class Alimento extends Producto {

    private int cantidadComensales;

    public Alimento() {
    }

    public Alimento(String nombre, String categoria, double precio, int stock, int cantidadComensales) {
        super(nombre, categoria, precio, stock);
        this.cantidadComensales = cantidadComensales;
    }

    public Alimento(int id, String nombre, double precio, int stock, int cantidadComensales) {
        super(id, nombre, precio, stock);
        this.cantidadComensales = cantidadComensales;
    }

    public int getCantidadComensales() {
        return cantidadComensales;
    }

    public void setCantidadComensales(int cantidadComensales) {
        this.cantidadComensales = cantidadComensales;
    }

    @Override
    public String toString() {
        return super.toString() + " | Comensales: " + cantidadComensales;
    }
}
