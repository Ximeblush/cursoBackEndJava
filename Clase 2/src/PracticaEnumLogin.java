//package enums;

import java.util.Scanner;

public class PracticaEnumLogin {

    // Definimos un enum llamado Usuario.
    // Sirve para representar un conjunto fijo de usuarios válidos.
    public enum Usuario {

        // Cada constante del enum representa un usuario
        // y guarda dos datos: nombre de usuario y clave.
        ADMIN("admin", "java123"),
        MIGUEL("miguel", "talento2026"),
        ALUMNO("alumno", "curso26138");

        // Atributos de cada usuario del enum.
        private final String nombre;
        private final String clave;

        // Constructor del enum.
        // Se ejecuta una vez por cada constante.
        Usuario(String nombre, String clave) {
            this.nombre = nombre;
            this.clave = clave;
        }

        // Método para obtener el nombre del usuario.
        public String getNombre() {
            return nombre;
        }

        // Método para obtener la clave del usuario.
        public String getClave() {
            return clave;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String usuarioIngresado;
        String claveIngresada;

        int intentos = 0;
        int maxIntentos = 3;

        boolean acceso = false;

        // Mientras no se superen los intentos y no haya acceso,
        // el programa seguirá pidiendo usuario y clave.
        while (intentos < maxIntentos && acceso == false) {
            System.out.println("Intento " + (intentos + 1) + " de " + maxIntentos);

            System.out.print("Ingrese usuario: ");
            usuarioIngresado = entrada.nextLine();

            System.out.print("Ingrese clave: ");
            claveIngresada = entrada.nextLine();

            // Validamos primero la longitud mínima de la clave.
            if (claveIngresada.length() < 6) {
                System.out.println("La clave debe tener al menos 6 caracteres.");
            } else {

                // Recorremos todos los valores del enum.
                // Usuario.values() devuelve todas las constantes:
                // ADMIN, MIGUEL y ALUMNO.
                for (Usuario u : Usuario.values()) {

                    // Comparamos lo ingresado con los datos guardados en el enum.
                    if (usuarioIngresado.equals(u.getNombre()) &&
                        claveIngresada.equals(u.getClave())) {
                        acceso = true;
                    }
                }

                if (acceso == true) {
                    System.out.println("Acceso concedido. Bienvenido.");
                } else {
                    System.out.println("Usuario o clave incorrectos.");
                }
            }

            intentos++;
            System.out.println();
        }

        // Si terminó el while y nunca se logró acceder,
        // se muestra el mensaje de bloqueo.
        if (acceso == false) {
            System.out.println("Cuenta bloqueada. Se agotaron los intentos.");
        }

        entrada.close();
    }
}