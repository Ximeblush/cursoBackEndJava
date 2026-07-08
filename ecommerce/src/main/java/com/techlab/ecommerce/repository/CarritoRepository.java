package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techlab.ecommerce.model.Carrito;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    @Query("SELECT c FROM Carrito c WHERE c.cliente.id = :clienteId")
    List<Carrito> findByClienteId(@Param("clienteId") int clienteId);

    @Query("SELECT c FROM Carrito c WHERE c.cliente.dni = :clienteDni")
    List<Carrito> findByClienteDni(@Param("clienteDni") int clienteDni);

    @Query("SELECT c FROM Carrito c WHERE c.cliente.id = :clienteId and c.producto.id = :productoId")
    Carrito findByClienteIdAndProductoId(@Param("clienteId") int clienteId, @Param("productoId") int productoId);

}
