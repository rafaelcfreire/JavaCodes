package leetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestArray {
    private PriorityQueue<Integer> heap;

    public int findKthLargest(int[] nums, int k) {
        heap = new PriorityQueue<>(k);

        for (int current : nums) {
            if (heap.size() < k)
                heap.add(current);
            else if (heap.peek() < current) {
                heap.poll();
                heap.add(current);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestArray kth = new KthLargestArray();
        int result = kth.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

}
