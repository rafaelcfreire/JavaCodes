package algoexpert.bst;

import java.util.ArrayList;
import java.util.List;

public final class BSTTraversal {
    public static void main(String[] args) {
        BST ten = new BST(10);
        BST five = new BST(5);
        BST fiveTwo = new BST(5);
        BST two = new BST(2);
        BST one = new BST(1);
        BST fifthTeen = new BST(15);
        BST twentyTwo = new BST(22);

        ten.left = five;
        ten.right = fifthTeen;

        five.left = two;
        five.right = fiveTwo;

        two.left = one;

        fifthTeen.right = twentyTwo;

        List<Integer> inOrder = inOrderTraverse(ten, new ArrayList<>());
        List<Integer> preOrder = preOrderTraverse(ten, new ArrayList<>());
        List<Integer> postOrder = postOrderTraverse(ten, new ArrayList<>());
        System.out.println(postOrder);
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return null;
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return null;
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return null;
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }
}
