package leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathsII {
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
        fourTwo.left = fiveTwo;
        fourTwo.right = one;

        pathSum(five, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();

        getPaths(root, new ArrayList<>(), paths, 0, targetSum);

        return paths;
    }

    private static void getPaths
        (TreeNode node, List<Integer> currentPath, List<List<Integer>> paths, int currSum, int targetSum) {

        if (node != null) {
            currentPath.add(node.val);
            currSum += node.val;

            if (node.left == null && node.right == null) {
                if (currSum == targetSum) {
                    paths.add(new ArrayList<>(currentPath));
                }
            } else {
                getPaths(node.left, currentPath, paths, currSum, targetSum);
                getPaths(node.right, currentPath, paths, currSum, targetSum);
            }
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
