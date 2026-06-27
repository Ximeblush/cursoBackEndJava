package com.techlab.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.model.Producto;


@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


@Bean
    public CommandLineRunner cargarDatos(ProductoService service) {
        return args -> {
            service.agregar(new Producto(1, " Milanesa con papas fritas ", 15000.0, 5));
        	service.agregar(new Producto(2, "Empanadas", 5000.0, 15));
        	service.agregar(new Producto(3, "Locrrrrrro", 11000.0, 8));
        	service.agregar(new Producto(4, "Locro", 10000.0, 9)); };
	}

}
