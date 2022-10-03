package algoexpert.searching;

public final class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 73));
    }

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target < array[middle])
                right = middle - 1;
            else if (target > array[middle])
                left = middle + 1;
            else if (target == array[middle])
                return middle;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        int middle = left + (right - left) / 2;

        if (target < array[middle])
            return binarySearchRecursive(array, target, left, middle - 1);
        else if (target > array[middle])
            return binarySearchRecursive(array, target, middle + 1, right);
        else if (target == array[middle])
            return middle;
        else
            return -1;
    }
}


//
//        while (left <= right) {
//                int middle = left + (right - left) / 2;
//                if (target < array[middle])
//        right = middle - 1;
//        else if (target > array[middle])
//        left = middle + 1;
//        else
//        return middle;
//        }
//        return -1;

