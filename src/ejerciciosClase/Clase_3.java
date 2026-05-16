package ejerciciosClase;
import java.util.ArrayList;

public class Clase_3 {

    //Tené una lista de productos con nombres desprolijos.
    //Creá un método que recorra la lista y aplique el formateo a cada nombre, volviendo a imprimir la lista con nombres prolijos.

    public static String formatearDescripcion(String descripcion) {

        String[] palabras = descripcion.trim().toLowerCase().split(" ");
        String resultado = "";

        for (String palabra : palabras) {
            resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " ";
        }
        return resultado.trim();
    }

    public static void main(String[] args) throws Exception {

        // Dada una cadena " té CHAi ", formateala para que quede "Té Chai".
        // Mostrá su longitud, su primera letra y verificá si contiene la palabra
        // "Chai".

        String bebida = " té CHAi ";
        System.out.println("String original: " + bebida);
        bebida = formatearDescripcion(bebida);
        System.out.println("String formateado: " + bebida);
        System.out.println("Longitud: " + bebida.length());
        System.out.println("Primera letra: " + bebida.substring(0, 1));
        if (bebida.contains("Chai")) {
            System.out.println("Sí, tiene Chai");
        } else {
            System.out.println("No tiene Chai");
        }
        System.out.println("¿Contiene 'Chai'? " + bebida.contains("Chai"));

        // Creá un array de 5 productos.
        // Imprimí sus elementos y luego intentá agregar un sexto producto (analizá el
        // resultado).

        String[] bebidas = new String[5];
        bebidas[0] = "Agua SIN gas ";
        bebidas[1] = " Agua con gas ";
        bebidas[2] = " GASEOSA";
        bebidas[3] = "Jugo";
        bebidas[4] = "Limonada";

        /*
         * o se puede escribir asi: ¿?
         * 
         * String[] bebidas = {
         * "Agua SIN gas ",
         * " Agua con gas ",
         * " GASEOSA",
         * "Jugo",
         * "Limonada"
         * };
         * 
         */

        for (int i = 0; i < bebidas.length; i++) {
            System.out.println(bebidas[i]);
            System.out.println(formatearDescripcion(bebidas[i]));
        }

        try { 
            //bebidas.add(" Milanesa con papas fritas "); //No se permite adherir en un
        // String
            System.out.println(bebidas[5]);
        } catch (Exception e) {
            System.out.println("El id 5 está fuera del rango del String");
        }

        // Creá un ArrayList<String> para productos.
        // Agregá varios productos, eliminá uno, verificá si otro existe y luego imprimí la lista final.
        
        ArrayList<String> listaProductos = new ArrayList<>();
        listaProductos.add(" Milanesa con papas fritas ");
        listaProductos.add("Empanadas");
        listaProductos.add("Locrrrrrro");
        listaProductos.add("Locro");
        
                //System.out.println(listaProductos[0]);
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i));
        }

        listaProductos.remove("Locrrrrrro");
        Boolean existe = false;

        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i));
            System.out.println(formatearDescripcion(listaProductos.get(i)));
            if (existe == false) {
                existe = listaProductos.get(i).contains("papas");
            }
        }

        System.out.println("¿Hay papas? " + existe);

    }
}
