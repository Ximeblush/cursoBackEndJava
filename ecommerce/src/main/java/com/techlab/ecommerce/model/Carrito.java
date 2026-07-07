package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data //Genera getters, setters, toString, equals y hashCode automáticamente.
@NoArgsConstructor //Genera un constructor sin argumentos automáticamente.
@AllArgsConstructor //Genera un constructor con todos los argumentos automáticamente.
@Entity //Indica que esta clase es una entidad de JPA.
@Table(name = "carrito") //Indica el nombre de la tabla en la base de datos
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)    
    @Positive(message = "La cantidad debe ser un número positivo")
    private int cantidad;

    @Column(name = "total", nullable = false)
    @Positive(message = "El total debe ser un número positivo") 
    private double total;
    
}
