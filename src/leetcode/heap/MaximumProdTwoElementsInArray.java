package leetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
public class MaximumProdTwoElementsInArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 7}));
    }

    public static int maxProduct(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(2);

        for (int current : nums) {
            if (heap.size() < 2)
                heap.offer(current);
            else if (heap.peek() < current) {
                heap.poll();
                heap.offer(current);
            }
        }
        return (heap.poll() - 1) * (heap.poll() - 1);
    }
}
