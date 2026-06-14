package ejerciciosClase.clase_7;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria", "maria64gmail.com");
        System.out.println(cliente);
        Cliente cliente2 = new Cliente("jose", "Jose@gmail.com");
        cliente2.setEmail("correo-sin-arroba");
        System.out.println(cliente2);

        //Producto producto = new Producto(1, "Milanesa", 10000, 25); //No se puede porque es abrtracta
        Comida producto1 = new Comida(1, "Milanesa", 10000, 25, "2026/08/01");
        Producto producto2 = new Comida(2, "Empanada", 5000, 20, "2026/08/15");
        Bebida producto3 = new Bebida(3, "Te", 3000, 200, 1);
        Producto producto4 = new Bebida(4, "Cafe", 4500, 50, 0.50);
        Producto producto5 = new Comida(5, "Pizza", 15000, 8, "2026/08/30");

        producto1.mostrarInformacion(); //sin sobreescribir el metodo mostrarInformacion en Comida, se ejecuta el metodo de Producto que no muestra el vencimiento
        producto4.mostrarInformacion(); //sobreescribí el método mostrarInformacion en Bebida para mostrar también el volumen de la bebida

        Carrito carrito = new Carrito(cliente2);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);        
        carrito.agregarProducto(producto4);        
        carrito.agregarProducto(producto5);

        System.out.println("Total del carrito: $" + carrito.calcularTotal());
        System.out.println("Productos creados: " + Producto.getCantidadProductos());

        System.out.println("Stock antes de probar valor negativo: " + producto1.getStock());
        producto1.setStock(-10);
        System.out.println("Stock despues de probar valor negativo: " + producto1.getStock());

        producto1.aplicarDescuento(10.0);
        System.out.println("Precio de " + producto1.getNombre() + " con descuento: $" + producto1.getPrecio());
        producto3.aplicarDescuento(20.0);
        System.out.println("Precio de " + producto3.getNombre() + " con descuento: $" + producto3.getPrecio());
    }
}
