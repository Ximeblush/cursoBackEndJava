package com.techlab.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController // Esto es para indicar que esta clase es un controlador de Spring. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
@RequestMapping("/productos")  // Define la url base de la clase. Esto es para indicar que todas las rutas de este controlador van a empezar con /productos. Son los endpoints del controlador. Es decir, si queremos listar los productos, la ruta va a ser /productos/listar. Si queremos agregar un producto, la ruta va a ser /productos/agregar, etc.
public class ProductoController {

    private final ProductoService service; // Si es final, no es crea el objeto con new, porque Spring lo genera automaticamente. Esto es para inyectar el servicio en el controlador. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.

    public ProductoController(ProductoService service) {
        this.service = service;
    }
    
    @GetMapping //Se inyectalaza el método de la pre-entrega ProductoService.listarProductos() por el endpoint /productos, es decir, cuando el cliente haga una petición GET a /productos, se va a ejecutar el método listarProductos() del servicio y se va a devolver la lista de productos al cliente.
    public List<Producto> listarProductos() {
        return service.listarProductos(); // Es el metodo de ProductoService que se inyecta en el controlador ProcutoContoller. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
    }

    @GetMapping("/{id}") //Se inyectalaza el método de la pre-entrega ProductoService.obtenerPorId() por el endpoint /productos/{id}, es decir, cuando el cliente haga una petición GET a /productos/{id}, se va a ejecutar el método obtenerPorId() del servicio y se va a devolver el producto con el id especificado al cliente.
    public Producto obtenerProducto(@PathVariable int id) {
        return service.obtenerPorId(id); // Es el metodo de ProductoService que se inyecta en el controlador ProcutoContoller. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
    }

    @PostMapping("")
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.agregar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {        
        service.borrar(id);
    }             
    

}
