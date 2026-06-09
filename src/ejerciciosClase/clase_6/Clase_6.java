package ejerciciosClase.clase_6;

public class Clase_6 {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria", "maria64gmail.com");
        System.out.println(cliente);
        Cliente cliente2 = new Cliente("jose", "Jose@gmail.com");
        cliente2.setEmail("correo-sin-arroba");
        System.out.println(cliente2);

        Producto producto1 = new Producto(1, "Milanesa", 10000, 25);
        Producto producto2 = new Producto(2, "Empanada", 15000, 20);
        Producto producto3 = new Producto(3, "Pizza", 80000, 8);

        Carrito carrito = new Carrito(cliente2);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);

        System.out.println("Total del carrito: $" + carrito.calcularTotal());
        System.out.println("Productos creados: " + Producto.getCantidadProductos());

        System.out.println("Stock antes de probar valor negativo: " + producto1.getStock());
        producto1.setStock(-10);
        System.out.println("Stock despues de probar valor negativo: " + producto1.getStock());
    }
}
