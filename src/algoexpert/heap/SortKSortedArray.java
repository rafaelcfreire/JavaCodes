package algoexpert.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
//        sortKSortedArray(new int[]{3, 2, 1, 5, 4, 7, 6, 5}, 3);
        sortKSortedArray(new int[]{-1, -3, -4, 2, 1, 3}, 2);
    }

    public static int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        int indexToInsert = 0;
        for (int current = 0; current < array.length; current++) {
            heap.offer(array[current]);

            if (heap.size() > k)
                array[indexToInsert++] = heap.poll();
        }
        while (indexToInsert < array.length)
            array[indexToInsert++] = heap.poll();

        return array;
    }
}
