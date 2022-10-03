package algoexpert.arrays;

public final class SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[]{26, 134, 135, 15, 17};

        smallestDifference(arrayOne, arrayTwo);
    }

    public static int[] smallestDifferenceBruteForce(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        int minAbsDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (Math.abs(arrayOne[i] - arrayTwo[j]) < minAbsDiff) {
                    result[0] = arrayOne[i];
                    result[1] = arrayTwo[j];
                    minAbsDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
                }
            }
        }
        return result;
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        sort(arrayOne, 0, arrayOne.length - 1);
        sort(arrayTwo, 0, arrayTwo.length - 1);
        int[] result = new int[2];
        int pointerOne = 0;
        int pointerTwo = 0;
        int minAbsDiff = Integer.MAX_VALUE;

        while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
            int current = Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]);
            if (current == 0 ) {
                result[0] = arrayOne[pointerOne];
                result[1] = arrayTwo[pointerTwo];
                break;
            }
            if (current < minAbsDiff) {
               result[0] = arrayOne[pointerOne];
               result[1] = arrayTwo[pointerTwo];
               minAbsDiff = current;
            }
            if (arrayOne[pointerOne] < arrayTwo[pointerTwo]) {
                pointerOne++;
            } else if (arrayOne[pointerOne] > arrayTwo[pointerTwo]) {
                pointerTwo++;
            }
        }
        return result;
    }

    private static void sort(int[] array, int low, int high) {
        if(high <= low) return;
        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int left = low, right = high + 1;
        int pivot = array[low];

        while(true) {
            while(array[++left] < pivot) {
                if(left == high)
                    break;
            }
            while(array[--right] > pivot) {
                if(right == low)
                    break;
            }
            if(right <= left) break;
            exchange(array, left, right);
        }
        exchange(array, low, right);
        return right;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}