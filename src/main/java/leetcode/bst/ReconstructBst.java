package leetcode.bst;

import java.util.List;

public final class ReconstructBst {
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
        int rightSubTreeRootIdx = preOrderTraversalValues.size();

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            if (preOrderTraversalValues.get(i) >= currentValue) {
                rightSubTreeRootIdx = i;
                break;
            }
        }

        BST leftTree = reconstructBst(preOrderTraversalValues.subList(1, rightSubTreeRootIdx));
        BST rightTree = reconstructBst(preOrderTraversalValues.subList(rightSubTreeRootIdx, preOrderTraversalValues.size()));

        BST node = new BST(currentValue);
        node.left = leftTree;
        node.right = rightTree;

        return node;
    }

    public static void main(String[] args) {
        BST root = reconstructBst(List.of(10, 4, 2, 1, 5, 17, 19, 18));
    }
}
