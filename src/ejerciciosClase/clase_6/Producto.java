package ejerciciosClase.clase_6;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    private static int cantidadProductos = 0;


    public Producto() {
        cantidadProductos++;
    }

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        setStock(stock);
        cantidadProductos++;
    }

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        setStock(stock);
        cantidadProductos++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        //Añadí una validación en el setter de cantidadEnStock para que no se permita asignar valores negativos
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock no puede ser negativo");
        }
    }

    public static int getCantidadProductos() {
        return cantidadProductos;
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
    }

    public double calcularDescuentoGeneral() {
        return precio * 0.90;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock;
    }
}
