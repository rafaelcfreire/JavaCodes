package leetcode.divide_and_conquer;

import leetcode.bst.TreeNode;

//https://leetcode.com/problems/maximum-binary-tree/description/
final class MaximumBinaryTree {

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        //TreeNode maxIndex = maximumBinaryTree.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        TreeNode maxIndex = maximumBinaryTree.constructMaximumBinaryTree(new int[]{3,2,1});
        System.out.println(maxIndex);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int lower, int higher) {
        if (lower > higher) {
            return null;
        }
        if (lower == higher) {
            int val = nums[lower];
            return new TreeNode(val);
        }
        int maxIndex = findIndexOfMaxValue(nums, lower, higher);
        return new TreeNode(nums[maxIndex],
                constructMaximumBinaryTree(nums, lower, maxIndex - 1),
                constructMaximumBinaryTree(nums, maxIndex + 1, higher));
    }

    private int findIndexOfMaxValue(int[] nums, int lower, int higher) {
        int maxValue = 0, maxIndex = Integer.MAX_VALUE;

        for (int i = lower; i <= higher; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}