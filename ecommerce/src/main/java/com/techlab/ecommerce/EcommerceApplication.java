package com.techlab.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;



@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


@Bean
    public CommandLineRunner cargarDatos(ProductoService service) {
        return args -> {
            if (service.listarProductos().isEmpty()) {
				service.agregar(new Producto("Milanesa con papas fritas", "Comida", 15000.0, 5));
				service.agregar(new Producto("Empanadas", "Comida", 5000.0, 15));
				service.agregar(new Producto("Locrrrro", "Comida", 11000.0, 8));
				service.agregar(new Producto("Locro", "Comida", 10000.0, 9));
			}
		};
	}
}
