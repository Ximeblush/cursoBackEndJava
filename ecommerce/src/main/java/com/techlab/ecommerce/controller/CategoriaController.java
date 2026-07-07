package com.techlab.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.techlab.ecommerce.exception.CategoriaNoEncontradaException;
import com.techlab.ecommerce.model.Categoria;   
import com.techlab.ecommerce.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service; // Si es final, no es crea el objeto con new, porque Spring lo genera automaticamente. Esto es para inyectar el servicio en el controlador. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }  
    
    @GetMapping //Se inyectalaza el método de la pre-entrega CategoriaService.listarCategorias() por el endpoint /categorias, es decir, cuando el cliente haga una petición GET a /categorias, se va a ejecutar el método listarCategorias() del servicio y se va a devolver la lista de categorías al cliente.
    public List<Categoria> listarCategorias() {
        return service.listarCategorias(); // Es el metodo de CategoriaService que se inyecta en el controlador CategoriaController. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar las categorías, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
    }

    @GetMapping("/{id}") //Se inyectalaza el método de la pre-entrega CategoriaService.obtenerPorId() por el endpoint /categorias/{id}, es decir, cuando el cliente haga una petición GET a /categorias/{id}, se va a ejecutar el método obtenerPorId() del servicio y se va a devolver la categoría con el id especificado al cliente.
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable int id) {
        //return service.obtenerPorId(id); // Es el metodo de CategoriaService que se inyecta en el controlador CategoriaController. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar las categorías, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        } catch (CategoriaNoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Categoria crearCategoria(@Valid @RequestBody Categoria categoria) {
        return service.agregar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable int id, @Valid @RequestBody Categoria datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable int id) {        
        service.borrar(id);
    }             
    

}