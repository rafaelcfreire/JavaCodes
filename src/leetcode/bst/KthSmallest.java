package leetcode.bst;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class KthSmallest {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        five.right = six;
        five.left = three;
        three.right = four;
        three.left = two;
        two.left = one;

        System.out.println(kthSmallest(five, 3));
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

    public static class TreeInfo {
        public int nodesVisited;
        public int lastValue;

        public TreeInfo(int nodesVisited, int lastValue) {
            this.nodesVisited = nodesVisited;
            this.lastValue = lastValue;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        kthSmallest(root, k, treeInfo);

        return treeInfo.lastValue;
    }

    public static void kthSmallest(TreeNode node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.nodesVisited > k)
            return;
        kthSmallest(node.left, k, treeInfo);
        if (treeInfo.nodesVisited < k) {
            treeInfo.nodesVisited += 1;
            treeInfo.lastValue = node.val;
            kthSmallest(node.right, k, treeInfo);
        }
    }

}
