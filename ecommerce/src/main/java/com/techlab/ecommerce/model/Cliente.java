package com.techlab.ecommerce.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;


@Data //Genera getters, setters, toString, equals y hashCode automáticamente.
@NoArgsConstructor //Genera un constructor sin argumentos automáticamente.
@AllArgsConstructor //Genera un constructor con todos los argumentos automáticamente.
@Entity //Indica que esta clase es una entidad de JPA.
@Table(name = "cliente") //Indica el nombre de la tabla en la base de datos
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Positive(message = "El DNI del cliente debe ser un número positivo")
    @NotNull(message = "El DNI del cliente no puede estar vacío")
    @Column(name = "dni", nullable = false, unique = true)
    private int dni;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido del cliente no puede estar vacío")
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    
    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
