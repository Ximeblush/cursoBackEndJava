package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.ecommerce.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

List<Cliente> findByDni(int dni);

    //@Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
    //List<Cliente> findByDni(@Param("dni") int dni);

}