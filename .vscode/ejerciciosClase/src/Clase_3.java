import java.util.ArrayList;

public class Clase_3 {
    public static void main(String[] args) throws Exception {

        String[] bebidas = new String[3];
        bebidas[0] = "Agua SIN gas ";
        bebidas[1] = " Agua con gas ";
        bebidas[2] = " GASEOSA";
        
        //bebidas.add(" Milanesa con papas fritas "); //No se permite adherir en un String
        
        ArrayList<String> listaProductos = new ArrayList<>();
        listaProductos.add(" Milanesa con papas fritas ");
        listaProductos.add("Empanadas");
        listaProductos.add("Locro");

        //System.out.println(listaProductos[0]);

        for (int i = 0 ; i < bebidas.length; i++) {
            System.out.println(bebidas[i]);
            System.out.println(formatearDescripcion(bebidas[i]));
        }

        if (listaProductos.contains("papas")) {
            System.out.println("Sí, tenemos papas");
        } else {
            System.out.println("No tenemos papas");
        }

        
        public static String formatearDescripcion(String descripcion) {
        
        String[] palabras = descripcion.trim().toLowerCase().split(" ");
            String resultado = "";

            for (String palabra : palabras) {
                resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " ";
            }
            return resultado.trim();
        }

    }
}
