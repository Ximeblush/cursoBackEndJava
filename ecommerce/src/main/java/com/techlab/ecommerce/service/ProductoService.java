package com.techlab.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.exception.ProductoNoEncontradoException;

@Service // Esto es para indicar que esta clase es un servicio de Spring. El servicio se encarga de realizar la lógica de negocio, es decir, de manejar los productos, de validar los datos, etc. El controlador no debe tener lógica de negocio, solo debe delegar en el servicio.
public class ProductoService {
        
    private List<Producto> productos = new ArrayList<>();
    //private Scanner sc = new Scanner(System.in);

   
    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("Producto con id " + id + " no encontrado");
    }   

    public Producto agregar(Producto p) {
        p.setId(productos.size() + 1); // Asignamos un id al producto. El id es el tamaño de la lista + 1. Esto es para que el id sea único y no se repita. El id es autoincremental.
        productos.add(p);
        return p;
    }

    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());
            return p;//"Producto con id " + id + " modificado con éxito";
        } else {
            throw new ProductoNoEncontradoException("Producto con id " + id + " no encontrado");
        }
    }

    public String borrar(int id) {
        Producto p = obtenerPorId(id);
         if (p != null) {
            productos.remove(p);
            return "Producto con id " + id + " eliminado";
        } else {
            throw new ProductoNoEncontradoException("Producto con id " + id + " no encontrado");
        }
    }


   /* 
   public Static void cargarProductos() {
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
*/


  /*  public static void buscarProducto() { 

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
                                p = obtenerPorId(id); // Llamamos al método obtenerPorId para buscar el producto por id. Si no se encuentra, se lanza la excepción ProductoNoEncontradoException.
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

    }*/
}
