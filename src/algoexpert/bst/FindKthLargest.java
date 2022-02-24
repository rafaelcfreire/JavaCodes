package algoexpert.bst;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargest {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int visitedNodes;
        public int lastValue;

        public TreeInfo(int visitedNodes, int lastValue) {
            this.visitedNodes = visitedNodes;
            this.lastValue = lastValue;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);

        reverseOrderTraversal(tree, k, treeInfo);
        return treeInfo.lastValue;
    }

    private void reverseOrderTraversal(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.visitedNodes > k)
            return;
        reverseOrderTraversal(node.right, k, treeInfo);
        if (treeInfo.visitedNodes < k) {
            treeInfo.visitedNodes += 1;
            treeInfo.lastValue = node.value;
            reverseOrderTraversal(node.left, k, treeInfo);
        }
    }
    public int findKthLargestValueInBstBruteForce(BST tree, int k) {
        List<Integer> inOrderValues = new ArrayList<>();

        inOrderTraversal(tree, inOrderValues);
        return inOrderValues.get(inOrderValues.size() - k);
    }

    private void inOrderTraversal(BST node, List<Integer> inOrderValues) {
        if (node == null)
            return;
        inOrderTraversal(node.left, inOrderValues);
        inOrderValues.add(node.value);
        inOrderTraversal(node.right, inOrderValues);
    }

    public static void main(String[] args) {
        BST one = new BST(1);
        BST two = new BST(2);
        BST three = new BST(3);
        BST five = new BST(5);
        BST fiveFive = new BST(5);
        BST fifhteen = new BST(15);
        BST seventeen = new BST(17);
        BST twenth = new BST(20);
        BST twenthTwo = new BST(22);

        two.left = one;
        two.right = three;

        five.left = two;
        five.right = fiveFive;

        fifhteen.left = five;
        fifhteen.right = twenth;

        twenth.left = seventeen;
        twenth.right = twenthTwo;

        FindKthLargest fkt = new FindKthLargest();
//        System.out.println(fkt.findKthLargestValueInBstBruteForce(fifhteen, 3));
        System.out.println(fkt.findKthLargestValueInBst(fifhteen, 9));
    }
}
