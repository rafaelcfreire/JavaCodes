package leetcode.bst;

import java.util.ArrayList;
import java.util.List;

public final class PathSumIII {
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode threeTwo = new TreeNode(3);
        TreeNode minusTwo = new TreeNode(-2);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode minusThree = new TreeNode(-3);
        TreeNode eleven = new TreeNode(11);

        ten.left = five;
        five.left = three;
        three.left = threeTwo;
        three.right = minusTwo;
        five.right = two;
        two.right = one;

        ten.right = minusThree;
        minusThree.right = eleven;

        pathSum(ten, 8);
//        TreeNode zero = new TreeNode(0);
//        TreeNode one = new TreeNode(1);
//        TreeNode oneOne = new TreeNode(1);
//
//        zero.left = one;
//        zero.right = oneOne;
//
//        pathSum(zero, 1);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();

        hasPath(root, new ArrayList<>(), targetSum, paths);

        return paths.size();
    }

    private static void hasPath(TreeNode node, List<Integer> currentPath, int targetSum, List<List<Integer>> paths) {
        if (node != null) {
            List<Integer> newCurrentPath = new ArrayList<>(currentPath);
            newCurrentPath.add(node.val);

            int currentSum = 0;
            for (int i = newCurrentPath.size(); i > 0; i--) {
                currentSum += newCurrentPath.get(i - 1);
                if (currentSum == targetSum) {
                    paths.add(newCurrentPath);
                }
            }
            hasPath(node.left, newCurrentPath, targetSum, paths);
            hasPath(node.right, newCurrentPath, targetSum, paths);
        }
    }
}
