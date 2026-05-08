//package enums;
public class enum2 {
    enum EstadoPedido {
        // =========================================================
        // PARTE 2: ENUM CON ATRIBUTOS, CONSTRUCTOR Y MÉTODOS
        // =========================================================
        // Un enum no solo guarda constantes.
        // También puede tener:
        // - atributos
        // - constructor
        // - métodos
        
        // Esto lo vuelve mucho más potente y organizado.
        // Cada constante llama al constructor del enum
        // y le pasa sus propios datos.
        
        PENDIENTE("Pendiente de revisión", 1),
        EN_PREPARACION("Pedido en preparación", 2),
        ENVIADO("Pedido enviado", 3),
        ENTREGADO("Pedido entregado", 4),
        CANCELADO("Pedido cancelado", 5);

        // -----------------------------------------------------
        // ATRIBUTOS
        // -----------------------------------------------------
        // Cada constante tendrá su propia descripción y código.
        private String descripcion;
        private int codigo;

        // -----------------------------------------------------
        // CONSTRUCTOR
        // -----------------------------------------------------
        // El constructor de un enum es privado implícitamente.
        // No se usa "new" desde afuera.
        // Se ejecuta una vez por cada constante al iniciar el programa.
        EstadoPedido(String descripcion, int codigo) {
            this.descripcion = descripcion;
            this.codigo = codigo;
        }

        // -----------------------------------------------------
        // MÉTODOS GET
        // -----------------------------------------------------
        // Permiten acceder a los atributos desde afuera.
        public String getDescripcion() {
            return descripcion;
        }

        public int getCodigo() {
            return codigo;
        }

        // -----------------------------------------------------
        // MÉTODO PROPIO
        // -----------------------------------------------------
        // Este método lo definimos nosotros para agregar comportamiento.
        public boolean estaFinalizado() {
            return this == ENTREGADO || this == CANCELADO;
        }

        // -----------------------------------------------------

        public static void main(String[] args) {

            /*
            */

            System.out.println("\n\n===== PARTE 2: ENUM CON MÉTODOS =====");

            // Creamos una variable del tipo EstadoPedido.
            EstadoPedido estado = EstadoPedido.EN_PREPARACION;

            System.out.println("Estado actual: " + estado);

            // ---------------------------------------------------------
            // MÉTODOS PROPIOS DEL ENUM
            // ---------------------------------------------------------
            // En este caso, cada estado tiene:
            // - una descripción
            // - un código numérico
            //
            // Y podemos acceder a esos datos con métodos.
            System.out.println("\nMétodos propios del enum:");
            System.out.println("Descripción: " + estado.getDescripcion());
            System.out.println("Código: " + estado.getCodigo());

            // También podemos llamar a otro método que definimos dentro del enum
            // para saber si el estado ya está finalizado.
            System.out.println("¿Está finalizado?: " + estado.estaFinalizado());

            // ---------------------------------------------------------
            // RECORRER TODOS LOS VALORES DEL ENUM
            // ---------------------------------------------------------
            // Acá volvemos a usar values(), pero ahora con más información.
            System.out.println("\nRecorrido completo de EstadoPedido:");

            for (EstadoPedido e : EstadoPedido.values()) {
                System.out.println(
                        "Constante: " + e.name() +
                                " | Descripción: " + e.getDescripcion() +
                                " | Código: " + e.getCodigo() +
                                " | Finalizado: " + e.estaFinalizado());
            }

            // ---------------------------------------------------------
            // valueOf() también funciona en enums con atributos y métodos
            // ---------------------------------------------------------
            System.out.println("\nvalueOf() en enum con métodos:");
            EstadoPedido otroEstado = EstadoPedido.valueOf("ENTREGADO");
            System.out.println("Estado convertido: " + otroEstado);
            System.out.println("Descripción: " + otroEstado.getDescripcion());

                   
            // ---------------------------------------------------------
            // COMPARAR ENUMS
            // ---------------------------------------------------------
            System.out.println("\nComparación de estados:");
            if (estado == EstadoPedido.EN_PREPARACION) {
                System.out.println("El pedido todavía se está preparando.");
            }

            if (otroEstado.estaFinalizado()) {
                System.out.println("El otro estado ya representa un proceso terminado.");
            }
        }
    }

}