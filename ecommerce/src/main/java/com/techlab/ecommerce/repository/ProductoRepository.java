package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techlab.ecommerce.model.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //Busco productos por nombre de producto ignorando mayúsculas y minúsculas y que contenga la cadena de búsqueda
    //El método findByNombreIgnoringCaseContaining es un método de Spring Data JPA que se encarga de buscar productos por nombre ignorando mayúsculas y minúsculas y que contenga la cadena de búsqueda. El método se encarga de generar la consulta SQL automáticamente, por lo que no es necesario escribirla manualmente. El método devuelve una lista de productos que cumplen con el criterio de búsqueda.
    //Es diferente a findByNombreContainingIgnoreCase ya que este busca
    List<Producto> findByNombreIgnoringCaseContaining(String nombre);
    
    //Busco productos por nombre de categoria.
    @Query("SELECT p FROM Producto p WHERE upper(p.categoria.nombre) = upper(:categoriaNombre)")
    List<Producto> findByCategoria(@Param("categoriaNombre") String categoriaNombre);
     
}
