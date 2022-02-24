package leetcode.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelTraversal {
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

//        TreeNode ten = new TreeNode(10);
//        TreeNode five = new TreeNode(5);
//        TreeNode three = new TreeNode(3);
//        TreeNode one = new TreeNode(1);
//        TreeNode seven = new TreeNode(7);
//        TreeNode six = new TreeNode(6);
//        TreeNode fifhteen = new TreeNode(15);
//        TreeNode thirteen = new TreeNode(13);
//        TreeNode eighteen = new TreeNode(18);
//
//        ten.left = five;
//        five.left = three;
//        three.left = one;
//        five.right = seven;
//        seven.left = six;
//
//        ten.right = fifhteen;
//        fifhteen.left = thirteen;
//        fifhteen.right = eighteen;

        levelOrder(three);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        int h = height(root);
        for (int i = 1; i <= h; i++)
            results.add(printCurrentLevel(root, i));

        return results;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        if (lHeight < rHeight) {
            return rHeight + 1;
        } else
            return lHeight + 1;
    }

    private static List<Integer> printCurrentLevel(TreeNode node, int height) {
        if (node == null)
            return null;
        if (height == 1)
            return List.of(node.val);
        else if (height > 1) {
            List<Integer> leftList = printCurrentLevel(node.left, height - 1);
            List<Integer> rightList = printCurrentLevel(node.right, height - 1);

            if (leftList == null && rightList != null)
                return rightList;
            else if (leftList != null && rightList == null)
                return leftList;
            else if (leftList != null && rightList != null) {
                return Stream.concat(leftList.stream(),
                        rightList.stream()).collect(Collectors.toList());
            }
        }
        return null;
    }
}
