package com.techlab.ecommerce.ui;
import java.util.Scanner;

//Menú principal interactivo

public class Menu {
    
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("===== SISTEMA DE GESTIÓN - TECHLAB =====");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("0) Salir");

            opcion = sc.nextInt();
 
            System.out.println("-----------------------");

            switch (opcion) {
                case 1: System.out.println("Ingrese el nuevo producto");
                        break;
                case 2: System.out.println("2) Listar productos");
                        break;
                case 3: System.out.println("3) Buscar/Actualizar producto");
                        break;
                case 4: System.out.println("4) Eliminar producto");
                        break;
                case 5: System.out.println("5) Crear pedido");
                        break;
                case 6: System.out.println("6) Listar pedidos");
                        break;
                case 0: System.out.println("0) Salir");
                        break;
                default: System.out.println("Opción no válida");
                        break;

            }
            
            System.out.println("-----------------------");

        } while (opcion != 0);
        
        sc.close();
    }
}
