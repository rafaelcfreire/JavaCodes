package algoexpert.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        radixSort(List.of(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
    }

    public static int[] radixSort(List<Integer> array) {
        int n = array.size();
        int R = 10;
        int[] aux = new int[n];
        int length = (int)(Math.log10(Collections.max(array))+1);

        for (int d = length; d >= 0; d--) {

        }
        return aux;
    }
}
