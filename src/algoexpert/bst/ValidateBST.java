package algoexpert.bst;

public class ValidateBST {

    public static void main(String[] args) {
//        BST ten = new BST(10);
//        BST five = new BST(5);
//        BST two = new BST(2);
//        BST one = new BST(1);
//        BST fiveTwo = new BST(5);
//        BST fifthteen = new BST(15);
//        BST thirteen = new BST(13);
//        BST twentyTwo = new BST(22);
//        BST fourteen = new BST(14);
//
//        ten.left = five;
//        five.left = two;
//        two.left = one;
//        five.right = fiveTwo;
//
//        ten.right = fifthteen;
//        fifthteen.left = thirteen;
//        thirteen.right = fourteen;
//        fifthteen.right = twentyTwo;

        BST one = new BST(-2147483648);
        BST two = new BST(2147483647);

        one.right = two;
        boolean result = validateBst(one);
    }

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBst(BST tree, long minValue, long maxValue) {
        if (tree.value <= minValue || tree.value >= maxValue)
            return false;
        if (tree.left != null && !validateBst(tree.left, minValue, tree.value))
            return false;
        if (tree.right != null && !validateBst(tree.right, tree.value, maxValue))
            return false;
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
