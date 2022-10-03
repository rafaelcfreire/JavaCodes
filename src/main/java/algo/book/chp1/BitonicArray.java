package algo.book.chp1;

public final class BitonicArray {
    public static void main(String[] args) {
        containsInteger(new int[]{1, 2, 3, 4, 3, 2, 1}, 3);
    }

    public static boolean containsInteger(int[] array, int target) {
        int low = 0, high = array.length / 2;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] < target) {
                low = middle + 1;
            } else if (array[middle] > target) {
                high = middle - 1;
            } else
                return true;
        }
        return false;
    }
}
