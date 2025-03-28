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
        return String.format("Producto:\nSKU: %s\nNombre: %s\nDescripción: %s\nCantidad por Talla: %s", SKU, nombre, descripcion, cantidadTalla.toString());
    }
}