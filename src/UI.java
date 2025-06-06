/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Clase: UI.java
 * Clase encargada de recibir las interacciones del 
 * usuario para ser procesadas. 
 */

import java.util.Scanner;

public class UI {
    /**
     * Muestra el menú principal de la interfaz de usuario y permite al usuario interactuar con las opciones disponibles.
    *
    * @param inventario El objeto de tipo Inventario donde se almacenan los productos.
    */
    public static void mostrarMenu(Inventario inventario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n+---------------------------------------+");
            System.out.println("|              Inventario               |");
            System.out.println("+---------------------------------------+");
            System.out.println("| 1. Mostrar listado de productos      |");
            System.out.println("| 2. Buscar un producto                |");
            System.out.println("| 3. Salir                             |");
            System.out.println("+---------------------------------------+");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("\n+---------------------------------------+");
                    System.out.println("|        Seleccione el orden           |");
                    System.out.println("+---------------------------------------+");
                    System.out.println("| 1. Ordenar por SKU                   |");
                    System.out.println("| 2. Ordenar por Nombre                |");
                    System.out.println("+---------------------------------------+");
                    System.out.print("Ingrese opción: ");
                    int orden = scanner.nextInt();
                    scanner.nextLine();
                    if (orden == 1) {
                        System.out.println("\nInventario ordenado por SKU:");
                        inventario.listarPorSKU();
                    } else if (orden == 2) {
                        System.out.println("\nInventario ordenado por Nombre:");
                        inventario.listarPorNombre();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    System.out.println("\n+---------------------------------------+");
                    System.out.println("|    Seleccione el criterio de        |");
                    System.out.println("|             búsqueda                |");
                    System.out.println("+---------------------------------------+");
                    System.out.println("| 1. Buscar por SKU                   |");
                    System.out.println("| 2. Buscar por Nombre                |");
                    System.out.println("+---------------------------------------+");
                    System.out.print("Ingrese opción: ");
                    int criterio = scanner.nextInt();
                    scanner.nextLine();
                    if (criterio == 1) {
                        System.out.print("Ingrese el SKU del producto: ");
                        String sku = scanner.nextLine();
                        Producto producto = inventario.buscarPorSKU(sku);
                        if (producto == null) {
                            System.out.println("Producto no encontrado.");
                        } else {
                            System.out.println("\n" + producto);
                        }
                    } else if (criterio == 2) {
                        System.out.print("Ingrese el Nombre del producto (sin tildes): ");
                        String nombre = scanner.nextLine();

                        nombre = nombre.toLowerCase();
                        Producto producto = inventario.buscarPorNombre(nombre);
                        if (producto == null) {
                            System.out.println("Producto no encontrado.");
                        } else {
                            System.out.println("\n" + producto);
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
} 