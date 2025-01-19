package leetcode.bst;

final class TreeNodeDeletion {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
//        TreeNode three = new TreeNode(3);
//        TreeNode six = new TreeNode(6);
//        TreeNode two = new TreeNode(2);
//        TreeNode four = new TreeNode(4);
//        TreeNode seven = new TreeNode(7);

//        five.left = three;
//        five.right = six;
//        three.left = two;
//        three.right = four;
//        six.right = seven;

        TreeNodeDeletion tnd = new TreeNodeDeletion();
        TreeNode root = tnd.deleteNode(five, 5);
        System.out.println(root);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode nodeParent = searchNodeParent(root, key);

        if (nodeParent == null && root.val != key) {
            //the key does not exist in the three
            return root;
        } else {
            TreeNode deletedNode;

            if (nodeParent != null) {
                //the node to be deleted is not the root
                if (nodeParent.left.val == key) {
                    deletedNode = nodeParent.left;
                } else {
                    deletedNode = nodeParent.right;
                }
            } else {
                deletedNode = root;
            }

            if (deletedNode != null) {
                if (deletedNode.left == null && deletedNode.right == null) {
                    //1 - if no child, simply delete the node
                    if (nodeParent != null) {
                        if (nodeParent.left == deletedNode) {
                            nodeParent.left = null;
                        } else {
                            nodeParent.right = null;
                        }
                    } else {
                        //corner case where a singled noded tree and delete the root
                        root = null;
                    }
                } else if (deletedNode.left == null || deletedNode.right == null) {
                    //2 - if it has a single child, just replace the parent
                    TreeNode child = deletedNode.left !=null ? deletedNode.left : deletedNode.right;
                    if (nodeParent != null) {
                        if (nodeParent.left == deletedNode) {
                            nodeParent.left = child;
                        } else {
                            nodeParent.right = child;
                        }
                    } else {
                        //root deletion
                        root.val = child.val;
                        root.left = child.left;
                        root.right = child.right;
                    }
                } else {
                    //3 - if it has 2 children, replace with the most left at the right node
                    TreeNode sucessor = getLeftmostDescendent(deletedNode.right);
                    deleteNode(root, sucessor.val);
                    deletedNode.val = sucessor.val;
                }
            }
        }
        return root;
    }

    private TreeNode getLeftmostDescendent(TreeNode node) {
        if (node.left != null) {
            return getLeftmostDescendent(node.left);
        }
        return node;
    }

    private TreeNode searchNodeParent(TreeNode root, int val) {
        if (root == null || root.left == null && root.right == null) {
            return null;
        }
        if (root.left != null && root.left.val == val || root.right.val == val) {
            return root;
        } else if (root.val > val) {
            return searchNodeParent(root.left, val);
        } else {
            return searchNodeParent(root.right, val);
        }
    }
}