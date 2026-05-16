package com.techlab.ecommerce.model;

//Clase Producto: con atributos id, nombre, precio, stock, getters y setters.

public class Producto {

    //Atributos
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    //Métodos

        //Constructores

     public Producto(){
        }
        
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(int id, String nombre, double precio, int stock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

        //Getters y Setters
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

        //Métodos propios de la clase ¿¿??

}