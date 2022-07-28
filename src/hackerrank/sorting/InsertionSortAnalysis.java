package hackerrank.sorting;

import java.util.List;
import java.util.stream.Collectors;

public class InsertionSortAnalysis {
    private static volatile int inversions = 0;

    public static void main(String[] args) {
        int result = insertionSort(List.of(2, 1, 3, 1, 2));
        int result2 = insertionSort(List.of(3, 5, 7, 11, 9));
    }

    public static int insertionSort(List<Integer> arr) {
        inversions = 0;
        sort(arr.stream().mapToInt(i -> i).toArray(), 0, arr.size() - 1);
        return inversions;
    }

    private static void sort(int[] array, int low, int high) {
        if (high <= low)
            return;
        int middle = low + (high - low) / 2;
        sort(array, low, middle);
        sort(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        int i = low, j = middle + 1;

        for (int k = j; k <= high; k++)
            for (int l = i; l <= middle; l++)
                if (array[k] < array[l])
                    inversions++;
    }

}
