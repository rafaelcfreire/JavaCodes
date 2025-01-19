package leetcode.bst;
// https://leetcode.com/problems/recover-binary-search-tree/?envType=problem-list-v2&envId=binary-search-tree
final class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);

        three.left = one;
        three.right = four;
        four.left = two;

        RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
        rbst.recoverTree(three);
    }

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        if (first != null && second != null) {
            swapNodesValues(first, second);
        }
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (previous != null && previous.val > root.val) {
            if (first == null) {
                first = previous;
            }
            second = root;
        }
        previous = root;
        inOrderTraversal(root.right);
    }

    private void swapNodesValues(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}