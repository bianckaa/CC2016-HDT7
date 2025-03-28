import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Inventario inventario = new Inventario();
        DocumentController.cargarCSV("inventario_ropa_deportiva_30.csv", inventario);
        
        System.out.println("Inventario por SKU:");
        inventario.listarPorSKU();

        System.out.println("\nBuscar por SKU '23': " + inventario.buscarPorSKU("023"));
    }
}