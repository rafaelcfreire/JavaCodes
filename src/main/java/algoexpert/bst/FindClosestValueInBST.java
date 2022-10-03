package algoexpert.bst;

public final class FindClosestValueInBST {
    public static void main(String[] args) {
        BST ten = new BST(10);
        BST five = new BST(5);
        BST two = new BST(2);
        BST one = new BST(1);
        BST fiveTwo = new BST(5);
        BST fifteen = new BST(15);
        BST thirteen = new BST(13);
        BST twentyTwo = new BST(22);
        BST fourteen = new BST(14);

        ten.left = five;
        five.left = two;
        two.left = one;
        five.right = fiveTwo;

        ten.right = fifteen;
        fifteen.left = thirteen;
        fifteen.right = twentyTwo;
        thirteen.right = fourteen;

        int result = findClosestValueInBst(ten, 12);
    }

    public static int findClosestValueInBst(BST tree, int target) {

        return findClosestValueInBstRecursive(tree, target, tree.value);
    }

    private static int findClosestValueInBstRecursive(BST tree, int target, int closestValue) {
        if (Math.abs(tree.value - target) < Math.abs(closestValue - target))
            closestValue = tree.value;
        if (tree.value > target && tree.left != null)
            return findClosestValueInBstRecursive(tree.left, target, closestValue);
        if (tree.value < target && tree.right != null)
            return findClosestValueInBstRecursive(tree.right, target, closestValue);
        return closestValue;
    }

    public static int findClosestValueInBst(BST tree, int target, int closestValue) {
        BST currentNode = tree;

        while (currentNode != null) {
            if (Math.abs(currentNode.value - target) < Math.abs(closestValue - target)) {
                closestValue = currentNode.value;
            }
            if (target < currentNode.value)
                currentNode = currentNode.left;
            else if (target > currentNode.value)
                currentNode = currentNode.right;
            else
                break;
        }
        return closestValue;
    }
}
