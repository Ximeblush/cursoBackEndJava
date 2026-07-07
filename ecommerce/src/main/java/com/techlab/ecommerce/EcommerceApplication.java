package com.techlab.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.model.Categoria;
import com.techlab.ecommerce.service.CategoriaService;
import com.techlab.ecommerce.model.Cliente;
import com.techlab.ecommerce.service.ClienteService;


@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


@Bean
    public CommandLineRunner cargarDatos(ProductoService productoService, CategoriaService categoriaService, ClienteService clienteService) {
        return args -> {
            if (productoService.listarProductos().isEmpty()) {
				Categoria comida = categoriaService.agregar(new Categoria("Comida", "Comida plato principal"));
				Categoria bebida = categoriaService.agregar(new Categoria("Bebida", "Bebidas no alcohólicas"));
				productoService.agregar(new Producto("Milanesa con papas fritas", comida, 15000.0, 5));
				productoService.agregar(new Producto("Empanadas", comida, 5000.0, 15));
				productoService.agregar(new Producto("Locrrrro", comida, 11000.0, 8));
				productoService.agregar(new Producto("Locro", comida, 10000.0, 9));
				productoService.agregar(new Producto("Agua", bebida, 1000.0, 20));
				productoService.agregar(new Producto("Gaseosa", bebida, 2000.0, 20));
				clienteService.agregar(new Cliente(12345678, "Juan", "Perez"));
				clienteService.agregar(new Cliente(87654321, "Maria", "Gonzalez"));
				clienteService.agregar(new Cliente(11111111, "Pedro", "Gomez"));
				clienteService.agregar(new Cliente(22222222, "Ana", "Lopez"));
			}
		};
	}
}
