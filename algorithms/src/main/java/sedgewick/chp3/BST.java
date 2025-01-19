package sedgewick.chp3;

import java.util.NoSuchElementException;

public final class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else return node.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node min = min(root);
        return min.key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null)
            throw new NoSuchElementException();
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, key);
        Node rightNode = floor(node.right, key);
        if (rightNode != null)
            return rightNode;
        else
            return node;
    }

    public Key select(int k) {
        if (k < 0 || k >= size())
            throw new IllegalArgumentException();
        Node node = select(root, k);
        return node.key;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int t = size(node.left);
        if (t > k)
            return select(node.left, k);
        else if (t < k)
            return select(node.right, k - t - 1);
        else
            return node;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(key, node.left);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(key, node.right);
        else
            return size(node.left);
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node newNode = node;
            node = min(newNode.right);
            node.right = deleteMin(newNode.right);
            node.left = newNode.left;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        System.out.println(node.key);
        print(node.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put('S', 0);
        bst.put('E', 1);
        bst.put('A', 2);
        bst.put('C', 3);
        bst.put('R', 4);
        bst.put('H', 5);
        bst.put('M', 6);
        bst.put('X', 7);

        bst.print();
//        bst.delete('R');

    }
}

//    if (node.left == null)
//        return node.right;
//    node.left = deleteMin(node.left);
//    node.n = size(node.left) + size(node.right) + 1;
//    return node;
