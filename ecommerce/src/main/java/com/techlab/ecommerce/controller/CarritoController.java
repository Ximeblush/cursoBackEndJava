package com.techlab.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.service.CarritoService;
import com.techlab.ecommerce.exception.CarritoNoEncontradoException;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController // Esto es para indicar que esta clase es un controlador de Spring. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
@RequestMapping("/carritos")  // Define la url base de la clase. Esto es para indicar que todas las rutas de este controlador van a empezar con /carrito. Son los endpoints del controlador. Es decir, si queremos listar los productos, la ruta va a ser /carrito/listar. Si queremos agregar un producto, la ruta va a ser /carrito/agregar, etc.
public class CarritoController {

    private final CarritoService service; // Si es final, no es crea el objeto con new, porque Spring lo genera automaticamente. Esto es para inyectar el servicio en el controlador. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.

    public CarritoController(CarritoService service) {
        this.service = service;
    }
    
    @GetMapping 
    public List<Carrito> listarCarritos() {
        return service.listarCarritos(); // Es el metodo de CarritoService que se inyecta en el controlador CarritoController. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los carritos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Carrito> obtenerCarritoCliente(@PathVariable int clienteId) {
        return service.buscarPorClienteId(clienteId);
    }
    
    @GetMapping("/{id}") //Se inyectalaza el método de la pre-entrega ProductoService.obtenerPorId() por el endpoint /productos/{id}, es decir, cuando el cliente haga una petición GET a /productos/{id}, se va a ejecutar el método obtenerPorId() del servicio y se va a devolver el producto con el id especificado al cliente.
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable int id) {
        //return service.obtenerPorId(id); // Es el metodo de ProductoService que se inyecta en el controlador ProcutoContoller. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
            } catch (CarritoNoEncontradoException e) {
                return ResponseEntity.notFound().build();
            }
    }
                
    @PostMapping("")
    public ResponseEntity<Carrito> agregarProductoAlCarrito(@Valid @RequestBody Carrito carrito) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agregar(carrito));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarProductoEnCarrito(@PathVariable int id, @Valid @RequestBody Carrito carrito) {
        try {
            return ResponseEntity.ok(service.actualizar(id, carrito));
            } catch (CarritoNoEncontradoException e) {
                return ResponseEntity.notFound().build();
            }
    }                
    
    @DeleteMapping("/{id}")
    public void eliminarProductoDelCarrito(@PathVariable int id) {        
        service.borrar(id);
    }             
    
}
