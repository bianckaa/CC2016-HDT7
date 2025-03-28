public class Inventario {
    BinarySearchTree<String, Producto> bstSKU = new BinarySearchTree<>();
    BinarySearchTree<String, Producto> bstNombre = new BinarySearchTree<>();

    /**
     * Agrega un producto al inventario.
     * El producto se inserta en dos árboles binarios de búsqueda: uno organizado por SKU y otro por nombre.
     *
     * @param producto El producto a agregar al inventario.
     */
    public void agregarProducto(Producto producto) {
        bstSKU.insert(producto.SKU, producto);
        bstNombre.insert(producto.nombre, producto);
    }

    /**
     * Busca un producto en el inventario utilizando su SKU.
     *
     * @param SKU El SKU del producto que se desea buscar.
     * @return El producto encontrado con el SKU proporcionado, o null si no se encuentra.
     */
    public Producto buscarPorSKU(String SKU) {
        return bstSKU.search(SKU);
    }

    /**
     * Busca un producto en el inventario utilizando su nombre.
     *
     * @param nombre El nombre del producto que se desea buscar.
     * @return El producto encontrado con el nombre proporcionado, o null si no se encuentra.
     */
    public Producto buscarPorNombre(String nombre) {
        return bstNombre.search(nombre);
    }

    /**
     * Realiza un recorrido en orden (in-order traversal) sobre el árbol binario de búsqueda organizado por SKU
     * y muestra la información de los productos.
     */
    public void listarPorSKU() {
        bstSKU.inOrderTraversal();
    }

    /**
     * Realiza un recorrido en orden (in-order traversal) sobre el árbol binario de búsqueda organizado por nombre
     * y muestra la información de los productos.
     */
    public void listarPorNombre() {
        bstNombre.inOrderTraversal();
    }
}
