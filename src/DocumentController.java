import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentController {
    public static void cargarCSV(String archivo, Inventario inventario) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        br.readLine(); // Saltar encabezado
        
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String SKU = partes[0], nombre = partes[1], descripcion = partes[2];
            Map<String, Integer> tallas = new HashMap<>();
            for (String talla : partes[3].split("\\|")) {
                String[] info = talla.split(":");
                tallas.put(info[0], Integer.parseInt(info[1]));
            }
            inventario.agregarProducto(new Producto(SKU, nombre, descripcion, tallas));
        }
        br.close();
    }
}
