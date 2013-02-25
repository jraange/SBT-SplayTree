import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SplayMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }
    public Node splay(Node h, K key)
    {
        return null;
    }


    @Override
    public void clear() {
        root = null;
        // TODO Auto-generated method stub

    }

    public boolean containsKey(Object arg0) {
        K key = (K) arg0;
        return (get(key) != null);
    }

    @Override
    public boolean containsValue(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(Object arg0) {
        K key = (K) arg0;
        root = splay(root, key);
        int cmp = (key).compareTo(root.key);
        if (cmp == 0) return root.value;
        else          return null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V put(K arg0, V arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public V remove(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        return null;
    }

}