package leetcode.bst;

// https://leetcode.com/problems/path-sum/

public final class PathSum {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourTwo = new TreeNode(4);
        TreeNode one = new TreeNode(1);

        five.left = four;
        four.left = eleven;
        eleven.left = seven;
        eleven.right = two;

        five.right = eight;
        eight.left = thirteen;
        eight.right = fourTwo;
        fourTwo.right = one;

        System.out.println(hasPathSum(five, 4));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return currentPathSum(root, 0, targetSum);
    }

    private static boolean currentPathSum(TreeNode node, int currentSum, int targetSum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && currentSum + node.val == targetSum)
            return true;
        return currentPathSum(node.left, currentSum + node.val, targetSum) ||
            currentPathSum(node.right, currentSum + node.val, targetSum);
    }
}