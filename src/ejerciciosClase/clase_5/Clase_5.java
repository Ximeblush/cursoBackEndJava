package ejerciciosClase.clase_5;

import java.util.ArrayList;
import java.util.List;

public class Clase_5 {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Micaela", "micaela@gmail.com");
        System.out.println(cliente);

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Maria", "maria@gmail.com"));
        clientes.add(new Cliente("Jose", "jose@gmail.com"));
        clientes.add(new Cliente("Ana", "ana@gmail.com"));
        clientes.add(new Cliente("Pablo", "pablo@gmail.com"));

        for (Cliente c : clientes) {
            System.out.println("Nombre: " + c.getNombre() + " | Email: " + c.getEmail());
            System.out.println(c);
        }

        Producto producto = new Producto();
        producto.setId(1);
        producto.setNombre("Milanesa");
        producto.setPrecio(10000);
        producto.setStock(100);

        Producto producto1 = new Producto(2, "Empanada", 15000, 20);
        producto.mostrarInformacion();
        System.out.println("Precio con descuento: $" + producto.calcularDescuentoGeneral());
        producto1.mostrarInformacion();
        System.out.println("Precio con descuento: $" + producto1.calcularDescuentoGeneral());
    }
}
