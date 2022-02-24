package algoexpert.sorting;

//https://stackoverflow.com/questions/159590/way-to-go-from-recursion-to-iteration
import algo.book.common.StdRandom;

public class QuickSort {
    public static void main(String[] args) {
        int[] value = new int[]{-1, 5, 10, 20, 28, 3};
//        int MAX = 500000;
//        int N = 500000;
//        int[] value = new int[N];
//        for (int i = 0; i < N; i++)
//            value[i] = StdRandom.uniform(0, MAX);
        int[] orderedArray = quickSort(value);
        System.out.println(orderedArray);
    }

    public static int[] quickSort(int[] array) {
        int[] orderedArray = new int[array.length];

        for (int i = 0; i < array.length; i++)
            orderedArray[i] = array[i];
        sort(orderedArray, 0, array.length - 1);

        return orderedArray;
    }

    private static void sort(int[] array, int low, int high) {
        if (high <= low)
            return;
        int pivotPosition = partition(array, low, high);
        sort(array, low, pivotPosition - 1);
        sort(array, pivotPosition + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int left = low, right = high + 1;
        int pivot = low;

        while (true) {
            while (array[left++] < array[pivot]) {
                if (left == high) break;
            }
            while (array[--right] > array[pivot]) {
                if (right == low) break;
            }
            if (right < left) break;
            exchange(array, left, right);
        }
        exchange(array, pivot, right);
        return right;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
