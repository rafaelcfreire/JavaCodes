package leetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public final class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(k);

        for (int current : nums)
            add(current);
    }

    public int add(int val) {
        if (heap.size() < k)
            heap.offer(val);
        else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargest test = new KthLargest(3, new int[]{2, 3, 5, 5, 4, 8});

    }
}