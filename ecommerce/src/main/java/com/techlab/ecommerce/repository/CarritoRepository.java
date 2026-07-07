package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techlab.ecommerce.model.Carrito;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

     @Query("SELECT c FROM Carrito c WHERE c.cliente.dni = :clienteDni")
    List<Carrito> findByClienteDni(@Param("clienteDni") int clienteDni);

}
