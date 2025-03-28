/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Referencias
 * https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf
 * https://somoshackersdelaprogramacion.es/arboles-binarios-de-busqueda-en-java
 * 
 * Clase: BinarySeachTree.java
 * Clase que implementa un Arbol Binario de Busqueda generico. 
 */
public class BinarySearchTree <K extends Comparable<K>, V>{
    private Node<K, V> root;

    /**
     * Inserta una clave y su valor asociado en el árbol.
     *
     * Si la clave ya existe en el árbol, se actualiza su valor.
     *
     * @param key La clave a insertar.
     * @param value El valor asociado a la clave.
     */
    public void insert(K key, V value){
        root = insertionRecursive(root, key, value);
    }

    /**
     * Método recursivo para insertar un nodo en el árbol.
     *
     * @param node El nodo actual.
     * @param key La clave a insertar.
     * @param value El valor asociado a la clave.
     * @return El nodo actualizado.
     */
    private Node<K, V> insertionRecursive(Node<K, V> node, K key, V value) {
        if (node == null) return new Node<>(key, value);
    
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insertionRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insertionRecursive(node.right, key, value);
        } else {
            node.value = value; // Si la clave ya existe, se actualiza el valor
        }
        return node;
    }    

    /**
     * Busca un valor asociado a una clave en el árbol.
     *
     * @param key La clave a buscar.
     * @return El valor asociado a la clave, o null si la clave no se encuentra.
     */
    public V search(K key) {
        Node<K, V> node = searchRecursive(root, key);
        return node != null ? node.value : null;
    }

    /**
     * Método recursivo para buscar un nodo en el árbol.
     *
     * @param node El nodo actual.
     * @param key La clave a buscar.
     * @return El nodo que contiene la clave, o null si no se encuentra.
     */
    private Node<K, V> searchRecursive(Node<K, V> node, K key) {
        if (node == null || node.key.equals(key)) return node;
        return key.compareTo(node.key) < 0 ? searchRecursive(node.left, key) : searchRecursive(node.right, key);
    }

    /**
     * Realiza un recorrido inorden (ordenado) del árbol y muestra los valores.
     * 
     */
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    /**
     * Método recursivo para realizar un recorrido inorden del árbol.
     * 
     * @param node El nodo actual.
     */
    private void inOrderTraversalRecursive(Node<K, V> node) {
        if (node != null) {
            inOrderTraversalRecursive(node.left);
            System.out.println(node.value + "\n");
            inOrderTraversalRecursive(node.right);
        }
    }
}
