package hackerrank.balancedtrees;

final class AVLTreeII {
    private Node root;

    Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            return node;
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1 && val < root.left.val) {
            return rightRotate(root);
        }
        if (balanceFactor < -1 && val > root.right.val) {
            return leftRotate(root);
        }
        if (balanceFactor > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return root.ht;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        AVLTreeII tree = new AVLTreeII();
        tree.root = root;
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 5);
        tree.insert(root, 6);
    }
}
