package leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.right = five;

        binaryTreePaths(one);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        getPaths(root, new ArrayList<>(), paths);

        List<String> allPaths = new ArrayList<>();
        convertLists(paths, allPaths);
        return allPaths;
    }

    private static void getPaths(TreeNode node, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node != null) {
            currentPath.add(node.val);

            if (node.left == null && node.right == null) {
                paths.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size() - 1);
            } else {
                getPaths(node.left, currentPath, paths);
                getPaths(node.right, currentPath, paths);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private static void convertLists(List<List<Integer>> paths, List<String> allPaths) {
        for (List<Integer> list : paths) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++)
                sb.append(list.get(i)).append("->");
            sb.append(list.get(list.size() - 1));
            allPaths.add(sb.toString());
        }
    }
}

class TreeNode {
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
