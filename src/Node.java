/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 7
 * Biancka Raxón 24960
 * 
 * Clase: Node.java
 * Clase que representa un nodo del árbol binario. 
 */

public class Node<K, V>{
    K key;
    V value;
    Node<K, V> left, right;

    /**
     * Constructor que inicializa el nodo con la clave y el valor proporcionados.
     * Los hijos izquierdo y derecho se establecen en null.
     *
     * @param key La clave asociada a este nodo.
     * @param value El valor asociado a este nodo.
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
