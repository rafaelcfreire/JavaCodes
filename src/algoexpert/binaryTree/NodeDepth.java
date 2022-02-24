package algoexpert.binaryTree;

public class NodeDepth {
    public static void main(String[] args) {
        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);

        one.left = two;
        two.left = four;
        four.left = eight;
        four.right = nine;

        two.right = five;

        one.right = three;
        three.left = six;
        three.right = seven;

        System.out.println(nodeDepths(one));
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree node, int depth) {
        if (node == null)
            return 0;

        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
    }
}
