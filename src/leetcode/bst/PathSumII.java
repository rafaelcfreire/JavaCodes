package leetcode.bst;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourTwo = new TreeNode(4);
        TreeNode fiveTwo = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        five.left = four;
        four.left = eleven;
        eleven.left = seven;
        eleven.right = two;

        five.right = eight;
        eight.left = thirteen;
        eight.right = fourTwo;
        fourTwo.right = one;
        fourTwo.left = fiveTwo;

        pathSum(five, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        hasPathSum(root, new ArrayList<Integer>(), 0, targetSum, result);

        return result;
    }

    private static void hasPathSum(TreeNode node, List<Integer> currentPath, int currentSum, int targetSum, List<List<Integer>> result) {
        if (node != null) {
            if (node.left == null && node.right == null && currentSum + node.val == targetSum) {
                List<Integer> newCurrentPath = new ArrayList<>(currentPath);
                newCurrentPath.add(node.val);
                result.add(newCurrentPath);
            }
            List<Integer> newCurrentPath = new ArrayList<>(currentPath);
            newCurrentPath.add(node.val);

            hasPathSum(node.left, newCurrentPath, currentSum + node.val, targetSum, result);
            hasPathSum(node.right, newCurrentPath, currentSum + node.val, targetSum, result);
        }
    }
}
