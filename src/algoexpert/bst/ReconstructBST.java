package algoexpert.bst;

import java.util.List;

public class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0)
            return null;

        int currentValue = preOrderTraversalValues.get(0);
        int rightIndex = preOrderTraversalValues.size();

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            if (currentValue <= preOrderTraversalValues.get(i)) {
                rightIndex = i;
                break;
            }
        }

        BST leftNode = reconstructBst(preOrderTraversalValues.subList(1, rightIndex));
        BST rightNode = reconstructBst(preOrderTraversalValues.subList(rightIndex,
                preOrderTraversalValues.size()));

        BST node = new BST(currentValue);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }


    public static void main(String[] args) {
        BST root = reconstructBst(List.of(10, 4, 2, 1, 5, 17, 19, 18));
    }

}
