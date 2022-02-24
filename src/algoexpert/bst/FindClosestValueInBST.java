package algoexpert.bst;

public class FindClosestValueInBST {
    public static void main(String[] args) {

    }
    public static int findClosestValueInBst(BST tree, int target) {

        return findClosestValueInBst(tree, target, tree.value);
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

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;

            while (true){
                if(value < currentNode.value) {
                    if(currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    }
                    else
                        currentNode = currentNode.left;
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else
                        currentNode = currentNode.right;
                }
            }
            return currentNode;
        }

        public boolean contains(int value) {
            BST currentNode = this;

            while (currentNode != null) {
                if (value < currentNode.value)
                    currentNode = currentNode.left;
                else if(value > currentNode.value)
                    currentNode = currentNode.right;
                else
                    return true;
            }
            return false;
        }
    }
}
