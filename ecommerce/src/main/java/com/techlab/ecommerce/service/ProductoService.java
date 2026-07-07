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
        //orElseThrow es un método de Optional que se encarga de devolver el valor si está presente, o de lanzar una excepción si no lo está. En este caso, si el producto con el id especificado no se encuentra en la base de datos, se lanza una excepción ProductoNoEncontradoException con un mensaje indicando que el producto no fue encontrado. Esto es para manejar el caso en el que el cliente haga una petición GET a /productos/{id} con un id que no existe en la base de datos. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
        //optional es una clase de Java que se utiliza para representar un valor que puede estar presente o no. En este caso, el método findById devuelve un Optional<Producto>, que puede contener un Producto si se encuentra en la base de datos, o estar vacío si no se encuentra. El método orElseThrow se utiliza para manejar el caso en el que el Optional esté vacío, lanzando una excepción en ese caso.
        // optional lo usa Spring Data JPA para manejar el caso en el que el producto con el id especificado no se encuentra en la base de datos. El método findById devuelve un Optional<Producto>, que puede contener un Producto si se encuentra en la base de datos, o estar vacío si no se encuentra. El método orElseThrow se utiliza para manejar el caso en el que el Optional esté vacío, lanzando una excepción en ese caso.
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

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreIgnoringCaseContaining(nombre);
    } 

    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

}
