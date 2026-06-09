package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Producto;

public class ProductoService {

    public static void cargarProductos() {
        productos.add(new Producto(1, " Milanesa con papas fritas ", 15000.0, 5));
        productos.add(new Producto(2, "Empanadas", 5000.0, 15));
        productos.add(new Producto(3, "Locrrrrrro", 11000.0, 8));
        productos.add(new Producto(4, "Locro", 10000.0, 9));

    }  

    public static void agregarProducto() { 

        //Scanner sc = new Scanner(System.in);

        System.out.println("Nuevo producto desde metodo:");
        System.out.println("Ingrese el nombre:");        
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio:");        
        double precio = sc.nextDouble();
        System.out.println("Ingrese el stock:");        
        int stock = sc.nextInt(); 
        int id = productos.size() + 1;   

        // Construimos el producto y lo enviamos al servicio.
        // El servicio se encarga de validar y de asignar el id.
        Producto p = new Producto(id, nombre, precio, stock);
        productos.add(p);

        System.out.println("Producto agregado con id " + p.getId());

    }

    public static void listarProductos() {

        System.out.println("Listado de productos:");

        for (Producto p : productos) {
            System.out.println("ID: " + p.getId() + " Nombre: " + p.getNombre() + " Precio: " + p.getPrecio() + " Stock: " + p.getStock()) ;
        }

    }

    public static void buscarProducto() { 

        //Scanner sc = new Scanner(System.in);
        int opcion;                

        do{
                System.out.println("Buscar Producto:");
                System.out.println("1) Buscar por id:");        
                System.out.println("2) Buscar por nombre:");    
                System.out.println("3) Volver al menú de opciones");    
                
                Producto p = new Producto();
                boolean existe = false;
                opcion = sc.nextInt();

                switch (opcion) {
                        case 1: System.out.println("Ingrese ID:");
                                int id = sc.nextInt();
                                for (Producto pb : productos) {
                                        if (pb.getId() == id) {
                                                p = pb;
                                                existe = true;
                                                break;
                                        }
                                } 
                                break;
                        case 2: System.out.println("Ingrese Nombre:");
                                sc.nextLine();
                                String nombre = sc.nextLine();
                                for (Producto pb : productos) {
                                        if (pb.getNombre().contains(nombre)) {
                                                p = pb;
                                                existe = true;
                                                break;
                                        }
                                }
                                break;
                        case 3: break;
                        default: System.out.println("Opción no válida");
                                break;

                }
                                
                if (existe == true) {
                        System.out.println("ID: " + p.getId() + " Nombre: " + p.getNombre() + " Precio: " + p.getPrecio() + " Stock: " + p.getStock()) ;
                        p = null;
                }
                else {
                        System.out.println("Producto no encontrado.");
                }

        } while (opcion != 3);


    }

    public static void eliminarProducto() { 

        //Scanner sc = new Scanner(System.in);
        Producto p = new Producto();
        boolean existe = false;

        System.out.println("Ingrese el ID del producto a eliminar:");
        int id = Integer.parseInt(sc.nextLine()); // Para no necesitar consumir el enter de nextint antes de usar el nextline.
        for (Producto pe : productos) {
                if (pe.getId() == id) {
                        p = pe;
                        existe = true;
                        break;
                }                
        } 

        if (existe) {
                System.out.println("¿Desea eliminar el siguiente producto?");
                System.out.println("ID: " + p.getId() + " Nombre: " + p.getNombre() + " Precio: " + p.getPrecio() + " Stock: " + p.getStock()) ;
                System.out.println("Ingrese S para Si y N para No");
                String confirmacion = sc.nextLine();  
                if (confirmacion.equalsIgnoreCase("S")) {     
                        productos.remove(p);
                        System.out.println("Producto eliminado");
                }
        }
        else {
                System.out.println("Producto no encontrado.");
        }

    }
}
