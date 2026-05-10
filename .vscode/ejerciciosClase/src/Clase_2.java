import java.util.Scanner;

public class Clase_2 {
    public static void main(String[] args) throws Exception {
                
        //Creá variables para representar el precio de un producto y la cantidad deseada por el cliente. Calculá y mostrale en pantalla el costo total.
        //Modificá el precio o la cantidad y verificá el resultado.
        int precio = 200;
        int cant = 10;
        double desc = 1;
        double costo = precio * cant;
        System.out.println("Costo: " + costo);

        //Pedile al usuario que ingrese su nombre y la cantidad de productos que quiere comprar.
        //Mostrá un mensaje personalizado con el monto total (asignando un precio fijo por unidad).
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresá tu nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Hola, " + nombre + "! Ingresa la cantidad deseada del producto: ");
        
        //Suponé que si el cliente quiere más de 100 unidades, le ofrecemos un descuento.
        //Implementá un if que verifique si cantidad > 100. Si es así, mostrá un mensaje indicando que aplica un descuento especial.
        cant = Integer.parseInt(sc.nextLine());
        sc.close();
        if (cant > 100) {
            System.out.println("Por la cantidad solicitada, corresponde un descuento del 10%");
            desc = 0.90;
        } else {
            desc = 1;
        }

        costo = (precio * cant) * desc;
        System.out.println("El costo total es de: $" + costo);
        
        //Pedile al usuario que ingrese un número, y luego usá un bucle for para imprimir desde 1 hasta ese número.
        //Repetí lo mismo con un while y compará cuál te resulta más intuitivo.
        for (int i = 1; i <= cant; i++) {
           System.out.println(i);
        }
        
        int i = 1;
        while (i <= cant) {
            System.out.println(i);
            i++;
        }
    }
}
