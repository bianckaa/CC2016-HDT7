/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Clase: DocumentController.java
 * Clase importa los datos de los productos alamcenados en un archivo CSV 
 * a un objeto de tipo Iventario. 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentController {

    /**
     * Carga los datos de productos desde un archivo CSV y los agrega al inventario proporcionado.
     * Los datos se normalizan para eliminar tildes y convertir a minúsculas.
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
            String SKU = datos[0];
            String nombre = quitarTildes(datos[1]);
            String descripcion = datos[2]; 
            Map<String, Integer> tallas = new HashMap<>();
            for (String talla : datos[3].split("\\|")) {
                String[] info = talla.split(":");
                tallas.put(info[0], Integer.parseInt(info[1]));
            }
            
            inventario.agregarProducto(new Producto(SKU, nombre, descripcion, tallas));
        }
        br.close();
    }

    /**
     * Elimina tildes y convierte una cadena a minúsculas.
     *
     * @param input La cadena a normalizar.
     * @return La cadena normalizada sin tildes y en minúsculas.
     */
    private static String quitarTildes(String input) {
        String normalized = java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD);
        String sinTildes = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        return sinTildes.toLowerCase();
    }
}
