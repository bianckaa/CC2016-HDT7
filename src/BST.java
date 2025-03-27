// Referencias
// https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf

import java.util.Comparator;
import javax.swing.tree.TreeNode;

public class BST <K, V>{
    private TreeNode<K, V> root;
    private Comparator<K> comparator;

    public BST (Comparator<K> comp) {
        root = null;
        comparator = comp;
    }

    public void add (K k, V v) {
        if (root == null) root = new TreeNode<K, V> (k, v, null, null);
        else root.add(k, v, comparator);
    }
    public void traverse () {
        if (root == null) System.out.println("Empty tree!");
        else root.traverse();
    }
    public V search (K key) {
        if (root == null) return null;
        return root.search(key, comparator);
    }
    public TreeNode<K, V> remove (K key) {
        if (root == null) return null;
        return root.remove(key, root, comparator);
    }
}
