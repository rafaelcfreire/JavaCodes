package algoexpert.sorting;

public final class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
    }

    public static int[] insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                exchange(array, j, j - 1);
            }
        }
        return array;
    }

    private static void exchange(int[] array, int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
