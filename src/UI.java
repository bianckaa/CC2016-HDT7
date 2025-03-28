import java.util.Scanner;

public class UI {
    public static void mostrarMenu(Inventario inventario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú de Inventario:");
            System.out.println("1. Mostrar listado de productos en orden");
            System.out.println("2. Buscar un producto por nombre o SKU");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccione el orden:");
                    System.out.println("1. Ordenar por SKU");
                    System.out.println("2. Ordenar por Nombre");
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
                    System.out.println("\nSeleccione el criterio de búsqueda:");
                    System.out.println("1. Buscar por SKU");
                    System.out.println("2. Buscar por Nombre");
                    System.out.print("Ingrese opción: ");
                    int criterio = scanner.nextInt();
                    scanner.nextLine();
                    if (criterio == 1) {
                        System.out.print("Ingrese el SKU: ");
                        String sku = scanner.nextLine();
                        System.out.println("Resultado: " + inventario.buscarPorSKU(sku));
                    } else if (criterio == 2) {
                        System.out.print("Ingrese el Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Resultado: " + inventario.buscarPorNombre(nombre));
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
