package main;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class SplayMap<K extends Comparable<K>, V> implements Map<K, V> {

    public Node root;
    private int size;

    private class Node implements Entry<K, V> {
        private final K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return newValue;
        }
    }

    private Node newNode(K key, V value) {
        ++size;
        return new Node(key, value);
    }


    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(Object arg0) {
        K key = (K) arg0;
        return (get(key) != null);
    }

    @Override
    public V get(Object arg0) {
        K key = (K) arg0;
        root = splay(root, key);
        int compareResult = (key).compareTo(root.key);
        if (compareResult == 0) return root.value;
        else return null;
    }

    @Override
    public V put(K arg0, V arg1) {
        K key = (K) arg0;
        V value = (V) arg1;
        if (root == null) {
            root = newNode(key, value);
            return null;
        }

        root = splay(root, key);

        int compereResult = key.compareTo(root.key);
        if (compereResult < 0) {
            Node n = newNode(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        } else if (compereResult > 0) {
            Node n = newNode(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }
        // Way for duplicated key
        else if (compereResult == 0) {
            root.value = value;
        }
        return null;
    }


    @Override
    public V remove(Object arg0) {
        K key = (K) arg0;

        if (root == null) return null; // empty tree

        root = splay(root, key);

        int compareResult = key.compareTo(root.key);

        if (compareResult == 0) {
            --size;
            if (root.left == null) {
                root = root.right;
            } else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
            return null;
        } else return null;

    }

    public Node splay(Node h, K key) {
        // main operation
        if (h == null)
            return null;

        int compareResult1 = key.compareTo(h.key);

        if (compareResult1 < 0) {
            if (h.left == null) {
                return h;
            }
            int compareResult2 = key.compareTo(h.left.key);
            if (compareResult2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = turnRight(h);
            } else if (compareResult2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = turnLeft(h.left);
            }

            if (h.left == null) return h;
            else return turnRight(h);
        } else if (compareResult1 > 0) {
            if (h.right == null) {
                return h;
            }

            int compareResult3 = key.compareTo(h.right.key);
            if (compareResult3 < 0) {
                h.right.left = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = turnRight(h.right);
            } else if (compareResult3 > 0) {
                h.right.right = splay(h.right.right, key);
                h = turnLeft(h);
            }

            if (h.right == null) return h;
            else return turnLeft(h);
        } else return h;
    }

    private Node turnRight(Node h) {
        // Turn right:)
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private Node turnLeft(Node h) {
        // Turn left:)
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }



    public static void main(String[] args) {
}

}
