public class Inventario {
    BinarySearchTree<String, Producto> bstSKU = new BinarySearchTree<>();
    BinarySearchTree<String, Producto> bstNombre = new BinarySearchTree<>();

    public void agregarProducto(Producto producto) {
        bstSKU.insert(producto.SKU, producto);
        bstNombre.insert(producto.nombre, producto);
    }

    public Producto buscarPorSKU(String SKU) {
        return bstSKU.search(SKU);
    }

    public Producto buscarPorNombre(String nombre) {
        return bstNombre.search(nombre);
    }

    public void listarPorSKU() {
        bstSKU.inOrderTraversal();
    }

    public void listarPorNombre() {
        bstNombre.inOrderTraversal();
    }
}
