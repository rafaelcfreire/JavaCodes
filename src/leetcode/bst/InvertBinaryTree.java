package leetcode.bst;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        four.left = two;
        four.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        TreeNode root = invertTree(four);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
