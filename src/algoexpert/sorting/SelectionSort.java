package algoexpert.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
    }

    public static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min])
                    min = j;
            }
            exchange(array, i, min);
        }
        return array;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
