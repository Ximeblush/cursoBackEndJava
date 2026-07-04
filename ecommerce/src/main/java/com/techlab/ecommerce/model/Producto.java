package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Clase Producto: con atributos id, nombre, precio, stock, getters y setters.
@Entity
@Table(name = "producto")
public class Producto {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "stock", nullable = false)
    private int stock;

    //Métodos

        //Constructores

     public Producto(){
        }
        
    public Producto(String nombre, String categoria, double precio, int stock){
        this.nombre = nombre;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    // toString() sobreescribe el método heredado de Object.
    // Sirve para mostrar el producto de forma legible al listarlo en consola. 
    // Cuando hagamos System.out.println(producto), Java llama automáticamente a este método.
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | Categoria: " + categoria +
                " | $" + precio +
                " | Stock: " + stock;
    }
}
