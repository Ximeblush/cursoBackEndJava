//package enums;
public class enum1 {

    // =========================================================
    // PARTE 1: ENUM SIMPLE
    // =========================================================
    // Un enum es un tipo especial de dato que nos permite
    // definir un conjunto fijo de constantes.
    //
    // Sirve cuando una variable solo puede tener ciertos valores
    // posibles y no cualquier texto o número.
    //
    // Ejemplo típico:
    // días de la semana, estados, niveles, colores, turnos, etc.
    enum Dia {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO
    }

    public static void main(String[] args) {

        System.out.println("===== PARTE 1: ENUM SIMPLE =====");

        // Creamos una variable de tipo Dia.
        // Como Dia es un enum, solo puede guardar uno de sus valores definidos.
        Dia diaActual = Dia.MARTES;

        System.out.println("Día actual: " + diaActual);

        // ---------------------------------------------------------
        // MÉTODO name()
        // ---------------------------------------------------------
        // Devuelve el nombre exacto de la constante tal como fue declarada.
        System.out.println("\nMétodo name():");
        System.out.println("Nombre exacto: " + diaActual.name());

        // ---------------------------------------------------------
        // MÉTODO ordinal()
        // ---------------------------------------------------------
        // Devuelve la posición de la constante dentro del enum.
        // IMPORTANTE: empieza desde 0.
        // LUNES = 0, MARTES = 1, MIERCOLES = 2, etc.
        //
        // Se puede mostrar para entender el enum,
        // pero no conviene basar lógica importante en ordinal().
        System.out.println("\nMétodo ordinal():");
        System.out.println("Posición: " + diaActual.ordinal());

        // ---------------------------------------------------------
        // MÉTODO values()
        // ---------------------------------------------------------
        // values() devuelve un arreglo con todas las constantes del enum.
        // Sirve mucho para recorrerlas con un for.
        System.out.println("\nMétodo values():");
        System.out.println("Todos los días del enum:");

        for (Dia d : Dia.values()) {
            System.out.println("- " + d);
        }

        // ---------------------------------------------------------
        // MÉTODO valueOf()
        // ---------------------------------------------------------
        // valueOf() permite convertir un texto en una constante del enum.
        // El texto debe coincidir exactamente con el nombre de la constante.
        System.out.println("\nMétodo valueOf():");
        Dia diaConvertido = Dia.valueOf("VIERNES");
        System.out.println("Texto convertido a enum: " + diaConvertido);

        // ---------------------------------------------------------
        // MÉTODO toString()
        // ---------------------------------------------------------
        // toString() devuelve la representación en texto del enum.
        // Si no se redefine, normalmente muestra el nombre de la constante.
        System.out.println("\nMétodo toString():");
        System.out.println("toString de diaActual: " + diaActual.toString());

        // ---------------------------------------------------------
        // COMPARACIÓN DE ENUMS
        // ---------------------------------------------------------
        // Los enums se comparan normalmente con ==
        // porque cada constante es única.
        System.out.println("\nComparación con ==");
        if (diaActual == Dia.MIERCOLES) {
            System.out.println("Hoy es miércoles.");
        }

        // ---------------------------------------------------------
        // USO EN IF
        // ---------------------------------------------------------
        // Como el enum solo admite valores concretos,
        // es muy útil para tomar decisiones.
        System.out.println("\nUso de enum en if:");

        if (diaActual == Dia.SABADO || diaActual == Dia.DOMINGO) {
            System.out.println("Es fin de semana.");
        } else {
            System.out.println("Es un día de semana.");
        }

        // ---------------------------------------------------------
        // USO EN SWITCH
        // ---------------------------------------------------------
        // Los enums funcionan muy bien con switch.
        System.out.println("\nUso de enum en switch:");

        switch (diaActual) {
            case LUNES:
                System.out.println("Comienza la semana.");
                break;
            case MIERCOLES:
                System.out.println("Estamos en la mitad de la semana.");
                break;
            case VIERNES:
                System.out.println("Ya casi termina la semana.");
                break;
            default:
                System.out.println("Es otro día.");
        }
    }
}
