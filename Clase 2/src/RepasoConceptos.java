public class RepasoConceptos {
    public static void main(String[] args) {
        // En esta clase repasamos conceptos básicos de Java, como variables, operadores, condicionales y bucles.
        
        /*
        
        // ---------------------------------------------------
        // 1. CREACIÓN DE VARIABLES
        // ---------------------------------------------------
        // Una variable es un espacio en memoria donde guardamos un dato.
        // Para crearla, indicamos:
        // tipoDeDato nombreVariable = valor;
        
        int numero = 10;         // variable primitiva entera
        double precio = 1500.75; // variable primitiva decimal
        char letra = 'J';        // variable primitiva de un solo carácter
        boolean activo = true;   // variable primitiva booleana (true o false)
        
        System.out.println("=== VARIABLES PRIMITIVAS ===");
        System.out.println("numero = " + numero);
        System.out.println("precio = " + precio);
        System.out.println("letra = " + letra);
        System.out.println("activo = " + activo);
        
        
        // ---------------------------------------------------
        // 2. DIFERENCIA ENTRE PRIMITIVAS Y WRAPPER
        // ---------------------------------------------------
        // Los tipos primitivos guardan directamente el valor.
        // Ejemplos: int, double, char, boolean.
        //
        // Los wrapper son clases que "envuelven" a los primitivos.
        // Ejemplos: Integer, Double, Character, Boolean.
        //
        // Los wrapper permiten usar métodos útiles y trabajar con objetos.
        
        int edad = 35;              // primitiva
        Integer edadWrapper = 35;   // wrapper del tipo int
        
        double sueldo = 250000.50;       // primitiva
        Double sueldoWrapper = 250000.50; // wrapper del tipo double
        
        System.out.println("\n=== PRIMITIVAS Y WRAPPER ===");
        System.out.println("edad (primitiva): " + edad);
        System.out.println("edadWrapper (wrapper): " + edadWrapper);
        System.out.println("sueldo (primitiva): " + sueldo);
        System.out.println("sueldoWrapper (wrapper): " + sueldoWrapper);
        
        // Ejemplo de algo que sí puede hacer un wrapper:
        String textoNumero = "45";
        Integer numeroConvertido = Integer.parseInt(textoNumero);
        
        System.out.println("Texto convertido con Integer.parseInt: " + numeroConvertido);
        
        // Otro método útil de wrapper:
        System.out.println("Máximo valor posible de int: " + Integer.MAX_VALUE);
        
        
        // ---------------------------------------------------
        // 3. OPERADORES ARITMÉTICOS
        // ---------------------------------------------------
        // Se usan para hacer cálculos matemáticos.
        int a = 20;
        int b = 6;
        
        int suma = a + b;
        int resta = a - b;
        int multiplicacion = a * b;
        int division = a / b; // al ser int, el resultado también será int
        int modulo = a % b;   // devuelve el resto de la división
        
        System.out.println("\n=== OPERADORES ARITMÉTICOS ===");
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);
        System.out.println("Módulo: " + modulo);
        
        
        // ---------------------------------------------------
        // 4. OPERADORES RELACIONALES
        // ---------------------------------------------------
        // Comparan valores y devuelven true o false.
        System.out.println("\n=== OPERADORES RELACIONALES ===");
        System.out.println("a > b  = " + (a > b));
        System.out.println("a < b  = " + (a < b));
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a >= b = " + (a >= b));
        System.out.println("a <= b = " + (a <= b));
        
        
        // ---------------------------------------------------
        // 5. OPERADORES LÓGICOS
        // ---------------------------------------------------
        // Se usan para combinar expresiones booleanas.
        boolean tieneDni = true;
        boolean viveEnCABA = false;
        boolean viveEnAMBA = true;
        
        System.out.println("\n=== OPERADORES LÓGICOS ===");
        System.out.println("tieneDni && viveEnAMBA = " + (tieneDni && viveEnAMBA));
        System.out.println("viveEnCABA || viveEnAMBA = " + (viveEnCABA || viveEnAMBA));
        System.out.println("!viveEnCABA = " + (!viveEnCABA));
        
        
        // ---------------------------------------------------
        // 6. OPERADORES DE ASIGNACIÓN E INCREMENTO
        // ---------------------------------------------------
        // Permiten modificar el valor de una variable.
        int contador = 5;
        
        System.out.println("\n=== ASIGNACIÓN E INCREMENTO ===");
        System.out.println("Valor inicial: " + contador);
        
        contador = contador + 3;
        System.out.println("contador = contador + 3 -> " + contador);
        
        contador += 2;
        System.out.println("contador += 2 -> " + contador);
        
        contador++;
        System.out.println("contador++ -> " + contador);
        
        contador--;
        System.out.println("contador-- -> " + contador);
        
        
        // ---------------------------------------------------
        // 7. CONDICIONALES
        // ---------------------------------------------------
        // Permiten tomar decisiones según una condición.
        int nota = 8;
        
        System.out.println("\n=== CONDICIONALES ===");
        if (nota >= 9) {
            System.out.println("Sobresaliente");
            } else if (nota >= 6) {
                System.out.println("Aprobado");
                } else {
                    System.out.println("Desaprobado");
                    }
                    
                    
                    // ---------------------------------------------------
                    // 8. BUCLE FOR
                    // ---------------------------------------------------
                    // Se usa cuando sabemos cuántas veces queremos repetir algo.
                    // Estructura:
                    // for (inicialización; condición; actualización)
                    
                    System.out.println("\n=== BUCLE FOR ===");
                    for (int i = 1; i <= 5; i++) {
                        int cuadrado = i * i;
                        System.out.println("Número: " + i + " - Cuadrado: " + cuadrado);
                        }
                        
                        
                        // ---------------------------------------------------
                        // 9. BUCLE WHILE
                        // ---------------------------------------------------
                        // Se ejecuta mientras la condición sea verdadera.
                        System.out.println("\n=== BUCLE WHILE ===");
                        int x = 3;
                        
                        while (x > 0) {
                            System.out.println("Valor actual de x: " + x);
                            x--;
                            }
                        
                        
        // ---------------------------------------------------
        // 10. BUCLE DO WHILE
        // ---------------------------------------------------
        // Similar al while, pero este se ejecuta al menos una vez.
        System.out.println("\n=== BUCLE DO WHILE ===");
        int y = 1;
        
        do {
            System.out.println("Valor actual de y: " + y);
            y++;
            } while (y <= 3);
            
            // ---------------------------------------------------
            // 11. COMBINACIÓN DE CONCEPTOS
            // ---------------------------------------------------
            // Acá mezclamos variables, operadores, condición y ciclo.
            System.out.println("\n=== COMBINACIÓN DE CONCEPTOS ===");
            
            int acumulador = 0;
            
            for (int i = 1; i <= 6; i++) {
                // Verificamos si el número es par usando el operador %
                if (i % 2 == 0) {
                    acumulador += i;
                    System.out.println("Se suma el número par: " + i);
                    } else {
                        System.out.println("Se ignora el número impar: " + i);
                        }
                        }
                        
                        System.out.println("Total acumulado de pares: " + acumulador);
                        
                        
                        
                        // ---------------------------------------------------
                        // 12. EJEMPLO SIMPLE DE WRAPPER VS PRIMITIVA
                        // ---------------------------------------------------
                        System.out.println("\n=== WRAPPER VS PRIMITIVA ===");
                        
                        int n1 = 100;
                        Integer n2 = 100;
                        
                        // La primitiva guarda directamente el número.
                        System.out.println("Primitiva n1: " + n1);
                        
                        // El wrapper además puede usar métodos.
                        System.out.println("Wrapper n2: " + n2);
                        System.out.println("n2 convertido a double: " + n2.doubleValue());
                        System.out.println("n2 en binario: " + Integer.toBinaryString(n2));
                    
                        // ---------------------------------------------------
                        // 13. Casteo de tipos
                        // ---------------------------------------------------
                        
                        // CASTEO IMPLÍCITO
                        // Un int puede guardarse en un double sin problema.
                        int edadd = 25;
                        double edadConvertida = edadd;
                        
                        System.out.println("Edad original (int): " + edadd);
                        System.out.println("Edad convertida a double: " + edadConvertida);
                        
                        // CASTEO EXPLÍCITO
                        // Un double puede tener decimales.
                        // Para guardarlo en un int hay que convertirlo manualmente.
                        double altura = 1.78;
                        int alturaEntera = (int) altura;
                        
                        System.out.println("Altura original (double): " + altura);
                        System.out.println("Altura convertida a int: " + alturaEntera);
                        
                        */
                }
                }