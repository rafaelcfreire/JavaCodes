package leetcode.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversals {
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.value = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode fifhteen = new TreeNode(15);
        TreeNode thirteen = new TreeNode(13);
        TreeNode eighteen = new TreeNode(18);

        ten.left = five;
        five.left = three;
        three.left = one;
        five.right = seven;
        seven.left = six;

        ten.right = fifhteen;
        fifhteen.left = thirteen;
        fifhteen.right = eighteen;

        inOrderTraversal(ten);
        System.out.println(" ");
        preOrderTraversal(ten);
        System.out.println(" ");
        postOrderTraversal(ten);
        System.out.println(" ");
        breadthFirstTraversal(ten);
        System.out.println(" ");
        System.out.println("Max Depth "+maxDepth(ten, 0, 0));
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value+", ");
        inOrderTraversal(node.right);
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value+", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        postOrderTraversal(node.right);
        postOrderTraversal(node.left);
        System.out.print(node.value+", ");
    }

    public static void breadthFirstTraversal(TreeNode node) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(node);

        while (deque.size() != 0) {
            TreeNode current = deque.pollFirst();
            System.out.print(current.value+", ");

            if (current.left != null) {
                deque.addLast(current.left);
            }
            if (current.right != null) {
                deque.addLast(current.right);
            }
        }
    }

    //Breadth first
    public static void levelOrderTraversal(TreeNode node) {
        int h = height(node);
        for (int i = 1; i <= h; i++)
            printLevel(node, i);
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);

            if (lHeight > rHeight)
                return lHeight + 1;
            else
                return rHeight + 1;
        }
    }

    private static void printLevel(TreeNode node, int depth) {
        if (node == null)
            return;
        if (depth == 1)
            System.out.print(node.value+", ");
        else {
            printLevel(node.left, depth - 1);
            printLevel(node.right, depth - 1);
        }
    }

    public static int maxDepth(TreeNode node, int depth, int maxDepth) {
        if (node == null)
            return maxDepth;
        if (node.left == null && node.right == null) {
            if (depth > maxDepth)
                maxDepth = depth;
            return maxDepth;
        }
        maxDepth = maxDepth(node.left, depth + 1, maxDepth);
        maxDepth = maxDepth(node.right, depth + 1, maxDepth);
        return maxDepth;
    }
}
