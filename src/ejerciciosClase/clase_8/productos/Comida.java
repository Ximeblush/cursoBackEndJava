package ejerciciosClase.clase_8.productos;

import ejerciciosClase.clase_8.productos.Producto;

public class Comida extends Producto implements Descontable {

    private String vencimiento;

    public Comida(String nombre, double precio, int stock, String vencimiento) {
        super(nombre, precio, stock);
        this.vencimiento = vencimiento;
    }

    public Comida( int id, String nombre, double precio, int stock, String vencimiento) {
        super(id, nombre, precio, stock);
        this.vencimiento = vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getVencimiento(){
        return vencimiento;
    }

    @Override
    public double calcularPrecioFinal() {
    return getPrecio() * 1;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        precio = precio - (precio * porcentaje / 100);
    }
}
