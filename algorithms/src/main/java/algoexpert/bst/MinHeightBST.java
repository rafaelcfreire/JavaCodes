package algoexpert.bst;

import java.util.List;

public final class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        int[] temp = array.stream().mapToInt(a -> a).toArray();
        return minHeightBst(temp,0, temp.length);
//        return minHeightBst(temp, null,0, temp.length - 1);
    }

    public static BST minHeightBst(int[] array, int low, int high) {
        if (high <= low)
            return null;
        int middle = low + (high - low) / 2;
        System.out.println(array[middle]);
        BST bst = new BST(array[middle]);
        bst.left = minHeightBst(array, low, middle);
        bst.right = minHeightBst(array, middle + 1, high);
        return bst;
    }

    public static BST minHeightBst(int[] array, BST node, int low, int high) {
        if (high <= low)
            return null;
        int middle = low + (high - low) / 2;
        System.out.println(array[middle]);
        if (node == null) {
            node = new BST(array[middle]);
        } else {
            //Instead of using the insert method, we can directly add the value and point to the child
            if (array[middle] < node.value) {
                node.left = new BST(array[middle]);
                node = node.left;
            } else {
                node.right = new BST(array[middle]);
                node = node.right;
            }
//            node.insert(array[middle]);
        }
        minHeightBst(array, node, low, middle);
        minHeightBst(array, node, middle + 1, high);
        return node;
    }

    public static void main(String[] args) {
        BST head = minHeightBst(List.of(1, 2, 5, 7, 10, 13, 14, 15, 22));
    }
}
