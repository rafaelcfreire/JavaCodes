package leetcode.bst;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

public final class MaxDepth {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifhteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;

        twenty.left = fifhteen;
        twenty.right = seven;

        System.out.println(maxDepth(three));
    }

    public static int maxDepth(TreeNode root) {
        return maxDepthRecursion(root, 0, 0);
    }

    private static int maxDepthRecursion(TreeNode node, int depth, int maxDepth) {
        if (node == null)
            return maxDepth;
        if (node.left == null && node.right == null) {
            if (depth > maxDepth)
                maxDepth = depth;
            return maxDepth;
        }
        maxDepth = maxDepthRecursion(node.left, depth + 1, maxDepth);
        maxDepth = maxDepthRecursion(node.right, depth + 1, maxDepth);
        return maxDepth;
    }
}
