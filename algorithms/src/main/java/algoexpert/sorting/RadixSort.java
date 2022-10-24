package algoexpert.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class RadixSort {
    public static void main(String[] args) {
        radixSort(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
    }

    // (int) (curr / Math.pow(10, 5)) % 10
    public static List<Integer> radixSort(List<Integer> array) {
        int max = Collections.max(array);

        int digit = 0;
        while ((max / Math.pow(10, digit)) > 0) {
            sort(array, digit);
            digit += 1;
        }
        return array;
    }

    private static void sort(List<Integer> array, int digit) {
        int n = array.size();
        int R = 10;
        int[] aux = new int[n];
        int[] count = new int[R + 1];

        for (int i = 0; i < n; i++) {
            int value = (int)(array.get(i) / Math.pow(10, digit)) % 10;
            count[value + 1]++;
        }

        for (int i = 0; i < R; i++)
            count[i + 1] += count[i];

        for (int i = 0; i < n; i++) {
            int temp = (int)(array.get(i) / Math.pow(10, digit)) % 10;
            aux[count[temp]++] = array.get(i);
        }

        for (int i = 0; i < n; i++)
            array.set(i, aux[i]);
    }
}
