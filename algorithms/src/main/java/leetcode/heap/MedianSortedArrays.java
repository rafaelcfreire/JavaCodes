package leetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public final class MedianSortedArrays {

    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        for (int current : nums1)
            addNumber(lower, higher, current);

        for (int current : nums2)
            addNumber(lower, higher, current);

        return findMedian(lower, higher);
    }

    private static void addNumber(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher, int number) {
        if (lower.size() == 0 || number < lower.peek())
            lower.offer(number);
        else
            higher.offer(number);
        rebalanceHeaps(lower, higher);
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() - higher.size() >= 2)
            higher.offer(lower.poll());
        else if (higher.size() - lower.size() >= 2)
            lower.offer(higher.poll());
    }

    private static double findMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() > higher.size())
            return lower.peek();
        else if (higher.size() > lower.size())
            return higher.peek();
        else
            return ((double) lower.peek() + higher.peek()) / 2.0;
    }
}
