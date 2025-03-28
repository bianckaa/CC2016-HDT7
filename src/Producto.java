import java.util.Map;

public class Producto {
    String SKU;
    String nombre;
    String descripcion;
    Map<String, Integer> cantidadTalla;
    
    public Producto(String SKU, String nombre, String descripcion, Map<String, Integer> cantidadTalla) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadTalla = cantidadTalla;
    }

    public String getSKU() {
        return SKU;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getCantidadTalla() {
        return cantidadTalla;
    }

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