package algoexpert.arrays;

public class MonotonicArray {
    public static void main(String[] args) {
//        System.out.println(isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
        System.out.println(isMonotonic(new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11}));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1)
            return true;

        int firstIndex = 0;
        boolean isCrescent = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                firstIndex = i + 1;
                isCrescent = array[i] < array[i + 1];
                break;
            }
        }

        for (int i = firstIndex; i < array.length - 1; i++) {
            if (isCrescent) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            } else {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
