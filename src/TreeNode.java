import java.util.Comparator;

public class TreeNode<K, V> {
    private KeyValuePair<K, V> pair;
    private TreeNode<K, V> left;
    private TreeNode<K, V> right;

    public TreeNode (K key, V value, TreeNode<K, V> left, TreeNode<K, V> right) {
        pair = new KeyValuePair<K, V> (key, value);
        this.left = left;
        this.right = right;
    }

    public void add (K key, V value, Comparator<K> comp) {
        if (comp.compare(key, pair.getKey()) == 0) pair.setValue(value);
        else if (comp.compare(key, pair.getKey()) < 0) {
        if (left == null) left = new TreeNode<K, V> (key, value, null, null);
        else left.add(key, value, comp);
        }
        else {
        if (right == null) right = new TreeNode<K, V> (key, value, null, null);
        else right.add(key, value, comp);
        }
    }

    public void traverse () {
        if (left != null) left.traverse();
        System.out.println(pair);
        if (right != null) right.traverse();
    }

    public V search (K key, Comparator<K> comp)  {
        int compRslt = comp.compare(key, pair.getKey());
        
        if (compRslt == 0) return pair.getValue();
        else if (compRslt < 0) {
        if (left == null) return null;
        else return left.search(key, comp);
        }
        else {
            if (right == null) return null;
            else return right.search(key, comp);
            }
    }

    public TreeNode<K, V> remove (K key, TreeNode<K, V> node, Comparator<K> comp) {
        if (node == null) return null;
        else if (comp.compare(key, node.pair.getKey()) < 0)
        node.left = remove(key, node.left, comp);
        else if (comp.compare(key, node.pair.getKey()) > 0)
        node.right = remove(key, node.right, comp);
        else
        node = removeNode(node, comp);
        
        return node;
    }

    private TreeNode<K, V> removeNode (TreeNode<K, V> node, Comparator<K> comp) {
        if (node.left == null) return node.right;
        else if (node.right == null) return node.left;
        else {
            KeyValuePair<K, V> p = getPredecessor(node.left);
            node.pair = p;
            node.left = remove(p.getKey(), node.left, comp);
            return node;
        }
    }
    private KeyValuePair<K, V> getPredecessor (TreeNode<K, V> subtree) {
        TreeNode<K, V> tmp = subtree;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.pair;
    }
}
