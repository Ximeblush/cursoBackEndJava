package com.techlab.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.repository.CarritoRepository;
import com.techlab.ecommerce.exception.CarritoNoEncontradoException;

@Service
public class CarritoService {
    
    private final CarritoRepository repository;

    public CarritoService(CarritoRepository repository) {
        this.repository = repository;
    }

    public List<Carrito> listarCarritos() {
        return repository.findAll();
    }

    public Carrito obtenerPorCliente(int dni) {
       return repository.findByClienteDni(dni).orElseThrow(() -> new CarritoNoEncontradoException("Carrito con cliente de dni " + dni + " no encontrado"));
       
    }   

    public Carrito agregar(Carrito carrito) {
        if (repository.findByClienteDni(carrito.getCliente().getDni()).isEmpty()) {
            return repository.save(carrito);
        } else {
            throw new CarritoNoEncontradoException("Carrito con cliente de dni " + carrito.getCliente().getDni() + " ya existe");
        }           
    }

    public Carrito actualizar(int dni, Carrito datos) {
        Carrito c = obtenerPorCliente(dni);
        if (c != null) {
            c.setNombre(datos.getNombre());
            c.setApellido(datos.getApellido());
            return repository.save(c);
        } else {
            throw new CarritoNoEncontradoException("Carrito con cliente de dni " + dni + " no encontrado");
        }
    }

    public void borrar(int dni) {
        Carrito c = obtenerPorCliente(dni);
         if (c != null) {
            repository.delete(c);            
        } else {
            throw new ClienteNoEncontradoException("Cliente con id " + id + " no encontrado");
        }
    }

}

