package com.techlab.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.ecommerce.model.Categoria;
import com.techlab.ecommerce.repository.CategoriaRepository;
import com.techlab.ecommerce.exception.CategoriaNoEncontrada;



@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

   
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }
    
    public Categoria obtenerPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new CategoriaNoEncontrada("Categoría con id " + id + " no encontrada"));
    }   

    public Categoria agregar(Categoria c) {
        return repository.save(c);
    }

    public Categoria actualizar(int id, Categoria datos) {
        Categoria c = obtenerPorId(id);
        if (c != null) {
            c.setNombre(datos.getNombre());
            c.setDescripcion(datos.getDescripcion());
            return repository.save(c);
        } else {
            throw new CategoriaNoEncontrada("Categoría con id " + id + " no encontrada");
        }
    }

    public void borrar(int id) {
        Categoria c = obtenerPorId(id);
         if (c != null) {
            repository.delete(c);            
        } else {
            throw new CategoriaNoEncontrada("Categoría con id " + id + " no encontrada");
        }
    }

}
