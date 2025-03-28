import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentController {
    /**
     * Carga los datos de productos desde un archivo CSV y los agrega al inventario proporcionado.
     *
     * @param archivo El nombre o ruta del archivo CSV a cargar.
     * @param inventario El objeto de tipo Inventario donde se agregarán los productos.
     * @throws IOException Si ocurre un error al intentar leer el archivo.
     */
    public static void cargarCSV(String archivo, Inventario inventario) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        br.readLine(); // Saltar encabezado
        
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String SKU = datos[0], nombre = datos[1], descripcion = datos[2];
            Map<String, Integer> tallas = new HashMap<>();
            for (String talla : datos[3].split("\\|")) {
                String[] info = talla.split(":");
                tallas.put(info[0], Integer.parseInt(info[1]));
            }
            inventario.agregarProducto(new Producto(SKU, nombre, descripcion, tallas));
        }
        br.close();
    }
}
