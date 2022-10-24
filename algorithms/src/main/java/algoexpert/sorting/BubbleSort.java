package algoexpert.sorting;

public final class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3});
    }

    public static int[] bubbleSort(int[] array) {
        boolean hasInversions = true;

        while(hasInversions) {
            int numOfInversions = 0;
            for(int i = 1; i < array.length; i++) {
                if(array[i - 1] > array[i]) {
                    exchange(array, i - 1, i);
                    numOfInversions++;
                }
            }
            if(numOfInversions == 0)
                hasInversions = false;
        }
        return array;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
