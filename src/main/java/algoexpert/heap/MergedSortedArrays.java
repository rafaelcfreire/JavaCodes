package algoexpert.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public final class MergedSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> items = List.of(List.of(1, 5, 9, 21), List.of(-1, 0), List.of(-124, 81, 121), List.of(3, 6, 12, 20, 150));
        mergeSortedArrays(items);
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> curr : arrays) {
            pq.addAll(curr);
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
