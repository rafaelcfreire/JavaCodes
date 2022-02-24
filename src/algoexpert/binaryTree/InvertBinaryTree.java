package algoexpert.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {
    public static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

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

//        invertBinaryTree(one);
        invertBinaryTreeIteractively(one);
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null)
            return;
        BinaryTree temp = tree.right;
        tree.right = tree.left;
        tree.left = temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void invertBinaryTreeIteractively(BinaryTree tree) {
        Deque<BinaryTree> deque = new ArrayDeque<>();
        deque.addLast(tree);

        while (deque.size() != 0) {
            BinaryTree current = deque.pollFirst();
            swapNodes(tree);

            if (current.left != null) {
                deque.addLast(current.left);
            }
            if (current.right != null) {
                deque.addLast(current.right);
            }
        }
    }

    private static void swapNodes(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }
}
