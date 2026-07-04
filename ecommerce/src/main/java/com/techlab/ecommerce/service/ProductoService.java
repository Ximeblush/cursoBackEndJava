package com.techlab.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import com.techlab.ecommerce.exception.ProductoNoEncontradoException;

@Service // Esto es para indicar que esta clase es un servicio de Spring. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
public class ProductoService {
        
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listarProductos() {
        return repository.findAll(); //El método findAll de JPA repository se encarga de devolver todos los productos de la base de datos.
    }

    public Producto obtenerPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new ProductoNoEncontradoException("Producto con id " + id + " no encontrado"));
    }   

    public Producto agregar(Producto p) {
        return repository.save(p); //El método save de JPA repository se encarga de asignar el id automáticamente, por lo que no es necesario asignarlo manualmente.
    }
 
    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setCategoria(datos.getCategoria());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());

            return repository.save(p);
            
        } else {
            throw new ProductoNoEncontradoException("Producto con id " + id + " no encontrado");
        }        
    }

    public void borrar(int id) {
        Producto p = obtenerPorId(id);
         if (p != null) {            
            repository.delete(p);
        } else {
            throw new ProductoNoEncontradoException("Producto con id " + id + " no encontrado");
        }
    }

}
