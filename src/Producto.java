/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Clase: Producto.java
 * Clase que representa Producto obtenido del archivo CSV. 
 */

 import java.util.Map;

public class Producto {
    String SKU;
    String nombre;
    String descripcion;
    Map<String, Integer> cantidadTalla;
    
    /**
     * Constructor que inicializa un producto con los detalles proporcionados.
     *
     * @param SKU El código único del producto (Stock Keeping Unit).
     * @param nombre El nombre del producto.
     * @param descripcion Una breve descripción del producto.
     * @param cantidadTalla Un mapa que asocia cada talla con la cantidad disponible de ese producto.
     */
    public Producto(String SKU, String nombre, String descripcion, Map<String, Integer> cantidadTalla) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadTalla = cantidadTalla;
    }

    /**
     * Obtiene el SKU del producto.
     *
     * @return El SKU del producto.
     */
    public String getSKU() {
        return SKU;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el mapa de cantidad por talla del producto.
     *
     * @return Un mapa que asocia cada talla con la cantidad disponible del producto.
     */
    public Map<String, Integer> getCantidadTalla() {
        return cantidadTalla;
    }

    /**
     * Devuelve una representación en formato de texto del producto.
     *
     * @return Una cadena de texto que representa los detalles del producto.
     */
    @Override
    public String toString(){
        StringBuilder cantidadTallaStr = new StringBuilder();
        for (Map.Entry<String, Integer> entry : cantidadTalla.entrySet()) {
            cantidadTallaStr.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return String.format("Detalles del Producto          \n" +
                            "+-------------------------------+\n" +
                            "SKU: %s\nNombre: %s\nDescripción: %s\nCantidad por Talla:\n%s", SKU, nombre, descripcion, cantidadTallaStr.toString());
    }
}