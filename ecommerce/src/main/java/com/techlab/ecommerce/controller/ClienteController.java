package com.techlab.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.techlab.ecommerce.model.Cliente;   
import com.techlab.ecommerce.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin //(origins = "http://localhost:5500") //Permite que el front-end pueda hacer peticiones al back-end desde otro origen, en este caso, desde el puerto 5500. Esto es necesario porque el front-end y el back-end están corriendo en puertos diferentes y el navegador bloquea las peticiones entre orígenes diferentes por seguridad. Esto se llama CORS (Cross-Origin Resource Sharing). El front-end está corriendo en el puerto 5500 porque se está usando Live Server para servir los archivos estáticos del front-end. El back-end está corriendo en el puerto 8080 porque es el puerto por defecto de Spring Boot.
public class ClienteController {

    private final ClienteService service; // Si es final, no es crea el objeto con new, porque Spring lo genera automaticamente. Esto es para inyectar el servicio en el controlador. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.

    public ClienteController(ClienteService service) {
        this.service = service;
    }  
    
    @GetMapping //Se inyectalaza el método de la pre-entrega ClienteService.listarClientes() por el endpoint /clientes, es decir, cuando el cliente haga una petición GET a /clientes, se va a ejecutar el método listarClientes() del servicio y se va a devolver la lista de clientes al cliente.
    public List<Cliente> listarClientes() {
        return service.listarClientes(); // Es el metodo de ClienteService que se inyecta en el controlador ClienteController. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los clientes, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
    }

    @GetMapping("/{id}") //Se inyectalaza el método de la pre-entrega ClienteService.obtenerPorId() por el endpoint /clientes/{id}, es decir, cuando el cliente haga una petición GET a /clientes/{id}, se va a ejecutar el método obtenerPorId() del servicio y se va a devolver el cliente con el id especificado al cliente.
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable int id) {
        //return service.obtenerPorId(id); // Es el metodo de CategoriaService que se inyecta en el controlador CategoriaController. El controlador se encarga de recibir las peticiones del cliente, de llamar al servicio para que realice la lógica de negocio y de devolver la respuesta al cliente. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar las categorías, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
        //try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        //} catch (ClienteNoEncontradoException e) {
        //    return ResponseEntity.notFound().build();
        //}
    }

    @PostMapping("")    
    public ResponseEntity<Cliente> crearCliente(@Valid @RequestBody Cliente cliente) {
    //public Cliente crearCliente(@Valid @RequestBody Cliente cliente) {
        //try {
            Cliente nuevoCliente = service.agregar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        //} catch (ClienteExistenteException e) {
        //    return ResponseEntity.badRequest().build();
        //}
        //return service.agregar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id, @Valid @RequestBody Cliente datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {        
        service.borrar(id);
        return ResponseEntity.ok().build();
    }     
    
}