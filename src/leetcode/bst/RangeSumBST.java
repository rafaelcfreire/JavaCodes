package leetcode.bst;

// https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode fifhteen = new TreeNode(15);
        TreeNode thirteen = new TreeNode(13);
        TreeNode eighteen = new TreeNode(18);

        ten.left = five;
        five.left = three;
        three.left = one;
        five.right = seven;
        seven.left = six;

        ten.right = fifhteen;
        fifhteen.left = thirteen;
        fifhteen.right = eighteen;

        System.out.print(rangeSumBST1(ten, 6, 10));
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

    public static int rangeSumBST1(TreeNode node, int low, int high) {
        int sum = 0;

        if (node == null)
            return 0;
        if (low < node.val)
            sum+= rangeSumBST1(node.left, low, high);
        if (low <= node.val && node.val <= high)
            sum+= node.val;
        if (node.val < high)
            sum+= rangeSumBST1(node.right, low, high);

        return sum;
    }
}
