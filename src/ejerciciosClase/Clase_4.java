package ejerciciosClase;
public class Clase_4 {
    //Escribí un método calcularImpuesto que reciba un precio y un porcentaje de impuesto y devuelva el precio final.
    
    public static double calcularImpuesto(double precio, double porcentaje) {
        double impuesto = precio * (porcentaje/100);
        double precioConImpuesto = precio + impuesto;
        return precioConImpuesto;
    }

    //Creá un método calcularPrecioFinal que reciba el precio, el descuento y la cantidad. Si la cantidad es mayor a 50, aumentá el descuento. Imprimí el resultado.
    
    public static double calcularPrecioFinal (double precio, double porcentaje, int cantidad) {
         if (cantidad > 50) {
            porcentaje += 5;
        }        
        double descuento = precio * (porcentaje/100);
        double precioConDescuento = precio - descuento;
        return precioConDescuento * cantidad;
    }

    //Escribí un método reponerStock que sume unidades a un índice específico del array.
    
    public static void reponerStock (int[] stock, int indice, int cantidad) {
        stock[indice] += cantidad;
    }

    //Creá dos métodos mostrarMensaje: uno recibe una String, otro recibe una String y un int.
    //Usá ambos para imprimir mensajes en función de si el cliente es nuevo o recurrente.

    public static void mostrarMensaje (String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarMensaje (String mensaje, int numero) {
        System.out.println(mensaje + " " + numero);
    }

    public static void main(String[] args) {
        Double precio = 100.0;
        Double impuesto = 21.0;
        Double descuento = 10.0;
        int cantidad = 1;

        //Escribí un método calcularImpuesto que reciba un precio y un porcentaje de impuesto y devuelva el precio final.
        //Llamá al método desde main con distintos valores.
        System.out.println(calcularImpuesto(precio, impuesto));
        
        precio = 1000.0;
        impuesto = 10.5;
        System.out.println(calcularImpuesto(precio, impuesto));

        //Creá un método calcularPrecioFinal que reciba el precio, el descuento y la cantidad. Si la cantidad es mayor a 50, aumentá el descuento. Imprimí el resultado.
        
        System.out.println(calcularPrecioFinal(precio, descuento, cantidad));

        cantidad = 100;
        System.out.println(calcularPrecioFinal(precio, descuento, cantidad));
    
        //Definí un array con el stock de 3 productos.
        //Escribí un método reponerStock que sume unidades a un índice específico del array.
        //Mostrá el stock antes y después de la reposición.

        int[] stock = {1, 30, 100};

        for (int i = 0; i < stock.length; i++) {
            System.out.println(stock[i]);
        }

        reponerStock(stock, 0, 10);
        
        for (int i : stock) {
            System.out.println(i);
        }

        //Usá ambos para imprimir mensajes en función de si el cliente es nuevo o recurrente.
        mostrarMensaje("Bienvenido! Su número de cliente es: ", 154);
        mostrarMensaje("Gracias por volver");

    }

}
