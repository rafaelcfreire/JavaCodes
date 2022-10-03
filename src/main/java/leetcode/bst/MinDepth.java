package leetcode.bst;

public final class MinDepth {
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

        System.out.println(minDepth(three));
    }

    public static int minDepth(TreeNode root) {
        return minDepth(root, 1, Integer.MAX_VALUE);
    }

    private static int minDepth(TreeNode node, int depth, int minDepth) {
        if (node == null)
            return minDepth;
        if (node.left == null && node.right == null) {
            if (depth < minDepth)
                minDepth = depth;
            return minDepth;
        }
        minDepth = minDepth(node.left, depth + 1, minDepth);
        minDepth = minDepth(node.right, depth + 1, minDepth);
        return minDepth;
    }
}
