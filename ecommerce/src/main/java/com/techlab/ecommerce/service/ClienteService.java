package com.techlab.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.ecommerce.model.Cliente;
import com.techlab.ecommerce.repository.ClienteRepository;
import com.techlab.ecommerce.exception.ClienteNoEncontradoException;
import com.techlab.ecommerce.exception.ClienteExistenteException;

@Service
public class ClienteService {
    
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public Cliente obtenerPorId(int id) {
       return repository.findById(id).orElseThrow(() -> new ClienteNoEncontradoException("Cliente con id " + id + " no encontrado"));
       
    }   

     public List<Cliente> buscarPorDni(int dni) {
        return repository.findByDni(dni);
    } 


    public Cliente agregar(Cliente c) {
        if (repository.findByDni(c.getDni()).isEmpty()) {
            return repository.save(c);
        } else {
            throw new ClienteExistenteException("Cliente con dni " + c.getDni() + " ya existe");
        }           
    }

    public Cliente actualizar(int id, Cliente datos) {
        Cliente c = obtenerPorId(id);
        if (c != null) {
            c.setNombre(datos.getNombre());
            c.setApellido(datos.getApellido());
            return repository.save(c);
        } else {
            throw new ClienteNoEncontradoException("Cliente con id " + id + " no encontrado");
        }
    }

    public void borrar(int id) {
        Cliente c = obtenerPorId(id);
         if (c != null) {
            repository.delete(c);            
        } else {
            throw new ClienteNoEncontradoException("Cliente con id " + id + " no encontrado");
        }
    }

}
