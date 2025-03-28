/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Clase: Main.java
 * Clase encargada de la ejecución del programa. 
 */
import java.io.IOException;

public class Main {
    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Carga el inventario desde un archivo CSV y luego muestra el menú de opciones para el usuario.
     *
     * @param args Los argumentos de la línea de comandos 
     * @throws IOException Si ocurre un error al intentar leer el archivo CSV.
     */
    public static void main(String[] args) throws IOException {
        Inventario inventario = new Inventario();
        
        DocumentController.cargarCSV("inventario_ropa_deportiva_30.csv", inventario);
        
        UI.mostrarMenu(inventario);
    }
}