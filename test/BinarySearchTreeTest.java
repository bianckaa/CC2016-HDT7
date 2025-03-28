import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree<String, Producto> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    private Map<String, Integer> obtenerTallas() {
        Map<String, Integer> tallas = new HashMap<>();
        tallas.put("S", 10);
        tallas.put("M", 10);
        tallas.put("L", 5);
        tallas.put("XL", 8);
        return tallas;
    }

    @Test
    void shouldInsertProductSKUInteger() {
        Producto producto = new Producto("123", "Jersey deportivo", "Playera de tela con absorción de sudor", obtenerTallas());
        bst.insert("123", producto);
        
        Producto resultado = bst.search("123");
        assertNotNull(resultado, "El producto debería haber sido insertado correctamente.");
        assertEquals("123", resultado.getSKU(), "El SKU del producto insertado debe coincidir.");
        assertEquals("Jersey deportivo", resultado.getNombre(), "El nombre del producto insertado debe coincidir.");
    }

    @Test
    void shouldInsertProductSKUString() {
        Producto producto = new Producto("abc", "Chumpa impermeable", "Chumpa ligera de nylon para ejercicio en exterior", obtenerTallas());
        bst.insert("abc", producto);
        
        Producto resultado = bst.search("abc");
        assertNotNull(resultado, "El producto debería haber sido insertado correctamente.");
        assertEquals("abc", resultado.getSKU(), "El SKU del producto insertado debe coincidir.");
        assertEquals("Chumpa impermeable", resultado.getNombre(), "El nombre del producto insertado debe coincidir.");
    }

    @Test
    void shouldInsertMultipleProducts() {
        Producto producto1 = new Producto("123", "Jersey deportivo", "Playera con absorción de sudor", obtenerTallas());
        Producto producto2 = new Producto("456", "Zapatillas running", "Zapatillas ligeras con amortiguación", obtenerTallas());
        Producto producto3 = new Producto("789", "Shorts deportivos", "Shorts de tela ligera", obtenerTallas());

        bst.insert("123", producto1);
        bst.insert("456", producto2);
        bst.insert("789", producto3);

        assertNotNull(bst.search("123"), "El producto con SKU 123 debería existir.");
        assertNotNull(bst.search("456"), "El producto con SKU 456 debería existir.");
        assertNotNull(bst.search("789"), "El producto con SKU 789 debería existir.");
    }

    @Test
    void shouldOverwriteExistingSKU() {
        Producto producto1 = new Producto("123", "Jersey deportivo", "Playera con absorción de sudor", obtenerTallas());
        Producto producto2 = new Producto("123", "Zapatillas running", "Zapatillas ligeras con amortiguación", obtenerTallas());

        bst.insert("123", producto1);
        bst.insert("123", producto2); 

        Producto resultado = bst.search("123");

        assertNotNull(resultado, "El producto con SKU 123 debería existir.");
        assertEquals("Zapatillas running", resultado.getNombre(), "El producto debe haber sido sobrescrito.");
    }


    @Test
    void shouldReturnProductsLookingFor() {
        Producto producto1 = new Producto("123", "Jersey deportivo", "Playera de tela con absorción de sudor", obtenerTallas());
        Producto producto2 = new Producto("abc", "Chumpa impermeable", "Chumpa ligera de nylon para ejercicio en exterior", obtenerTallas());

        bst.insert("123", producto1);
        bst.insert("abc", producto2);

        Producto resultado1 = bst.search("123");
        Producto resultado2 = bst.search("abc");
        Producto resultadoInexistente = bst.search("999");

        assertNotNull(resultado1, "El producto con SKU 123 debería existir.");
        assertEquals("Jersey deportivo", resultado1.getNombre(), "El nombre del producto debe coincidir.");

        assertNotNull(resultado2, "El producto con SKU abc debería existir.");
        assertEquals("Chumpa impermeable", resultado2.getNombre(), "El nombre del producto debe coincidir.");

        assertNull(resultadoInexistente, "Buscar un SKU inexistente debería devolver null.");
    } 
}