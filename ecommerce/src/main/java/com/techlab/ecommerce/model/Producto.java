package com.techlab.ecommerce.model;

import jakarta.persistence.*;
/*
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
*/
import jakarta.validation.constraints.*;
/*
import jakarta.validation.constraints.blank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
*/
//Clase Producto: con atributos id, nombre, precio, stock, getters y setters.
@Entity
@Table(name = "producto")
public class Producto {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
        
    @ManyToOne
    @JoinColumn(name = "categoria_id")    
    private Categoria categoria;
    
    @Positive(message = "El precio del producto debe ser mayor a 0")
    @Column(name = "precio", nullable = false)
    private double precio;
    
    @PositiveOrZero(message = "El stock del producto no puede ser negativo")    
    @Column(name = "stock", nullable = false)
    private int stock;

    //Métodos

        //Constructores

     public Producto(){
        }
        
    public Producto(String nombre, Categoria categoria, double precio, int stock){
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
