package algoexpert.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static void main(String[] args) {
        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree ten = new BinaryTree(10);

        one.left = two;
        two.left = four;
        four.left = eight;
        four.right = nine;
        two.right = five;
        five.left = ten;
        one.right = three;
        three.left = six;
        three.right = seven;

//        List<Integer> result = branchSums(one);
        branchSums(one);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree node) {
        List<Integer> sums = new ArrayList<>();

        branchSums(node, 0, sums);

        return sums;
    }

    private static void branchSums(BinaryTree node, int currentSum, List<Integer> sums) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            sums.add(currentSum + node.value);
        }
        branchSums(node.left, currentSum + node.value, sums);
        branchSums(node.right, currentSum + node.value, sums);
    }
}







//        if (node == null)
//        return;
//
//        int runningSum = currentSum + node.value;
//        if (node.left == null && node.right == null) {
//        sums.add(runningSum);
//        return;
//        }
//        branchSums(node.left, runningSum, sums);
//        branchSums(node.right, runningSum, sums);
