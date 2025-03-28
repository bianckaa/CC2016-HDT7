// Referencias
// https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf

public class BinarySearchTree <K extends Comparable<K>, V>{
    private Node<K, V> root;

    public void insert(K key, V value){
        root = insertionRecursive(root, key, value);
    }

    private Node<K, V> insertionRecursive(Node<K, V> node, K key, V value) {
        if (node == null) return new Node<>(key, value);
        if (key.compareTo(node.key) < 0) node.left = insertionRecursive(node.left, key, value);
        else node.right = insertionRecursive(node.right, key, value);
        return node;
    }

    public V search(K key) {
        Node<K, V> node = searchRecursive(root, key);
        return node != null ? node.value : null;
    }

    private Node<K, V> searchRecursive(Node<K, V> node, K key) {
        if (node == null || node.key.equals(key)) return node;
        return key.compareTo(node.key) < 0 ? searchRecursive(node.left, key) : searchRecursive(node.right, key);
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<K, V> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.value);
            inOrderRecursive(node.right);
        }
    }
}
