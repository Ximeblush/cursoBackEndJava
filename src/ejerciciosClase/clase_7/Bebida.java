package ejerciciosClase.clase_7;

public class Bebida extends Producto implements Descontable {

    private double litros;

    public Bebida(String nombre, double precio, int stock, double litros) {
        super(nombre, precio, stock);
        this.litros = litros;
    }

    public Bebida( int id, String nombre, double precio, int stock, double litros) {
        super(id, nombre, precio, stock);
        this.litros = litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getLitros(){
        return litros;
    }
    
    @Override
    public double calcularPrecioFinal() {
    //return getPrecio() * 0.95; Ya no necesito el getPrecio porque precio es protected en Producto, entonces puedo acceder directamente
    return precio * 0.95;
    }

    @Override
     public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Volumen: " + litros);
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        precio = precio - (precio * porcentaje / 100);
    }

}
