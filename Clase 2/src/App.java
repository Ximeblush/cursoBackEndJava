import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int precio = 200;
        int cant = 10;
        double desc = 1;
        double costo = precio * cant;
        System.out.println(costo);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresá tu nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Hola, " + nombre + "! Ingresa la cantidad deseada del producto: ");
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
