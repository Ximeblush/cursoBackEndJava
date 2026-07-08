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

    public Carrito obtenerPorId(int id) {
       return repository.findById(id).orElseThrow(() -> new CarritoNoEncontradoException("Carrito con id " + id + " no encontrado"));
       
    }
    
    public List<Carrito> buscarPorClienteId(int clienteId) {
       return repository.findByClienteId(clienteId);
    }

    public List<Carrito> buscarPorDni(int dni) {
        return repository.findByClienteDni(dni);
    } 

    /*
    public Carrito buscarPorClienteProducto(int clienteId, int productoId) {
        return repository.findByClienteIdAndProductoId(clienteId, productoId);
    } 
    */

    public Carrito agregar(Carrito carrito) {
        Carrito c = repository.findByClienteIdAndProductoId(carrito.getCliente().getId(), carrito.getProducto().getId());
        if (c == null) {
            return repository.save(carrito);
        } else {
            c.setCantidad(carrito.getCantidad() + c.getCantidad());
            actualizar(c.getId(), c);
            return c;
        }           
    }

    public Carrito actualizar(int id, Carrito datos) {
        if (datos.getCantidad() > 0) {            
            Carrito c = obtenerPorId(id);
            if (c != null && datos.getCantidad() > 0) {
                c.setCantidad(datos.getCantidad());
                return repository.save(c);
            } else {
                throw new CarritoNoEncontradoException("Carrito con id " + id + " no encontrado");
            }
        } else {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
    }

    public void borrar(int id) {
        Carrito c = obtenerPorId(id);
        //if (c.getCantidad() > 1) {
        //    c.setCantidad(c.getCantidad()-1);
        //    actualizar(c.getId(), c);
        //} else if (c.getCantidad() == 1) {
        //    repository.delete(c);         
        if (c != null) {
            repository.delete(c);
        } else {
            throw new CarritoNoEncontradoException("Carrito con id " + id + " no encontrado");
        }
    }

}