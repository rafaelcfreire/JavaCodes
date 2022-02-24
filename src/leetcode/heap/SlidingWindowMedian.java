package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {

    public static void main(String[] args) {
//        medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 4);
        medianSlidingWindow(new int[]{
                -2147483648,-2147483648,
                2147483647,-2147483648,
                -2147483648,-2147483648,
                2147483647,2147483647,
                2147483647,2147483647,
                -2147483648,2147483647,
                -2147483648},
        2);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length < k)
            return new double[]{};

        if (k == 1)
            return Arrays.stream(nums).asDoubleStream().toArray();

        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        double[] results = new double[nums.length - (k - 1)];

        for (int index = 0; index <= nums.length; index++) {
            if (index >= k) {
                double median;
                if (lower.size() > higher.size()) {
                    median = lower.peek();
                } else if (lower.size() < higher.size()) {
                    median = higher.peek();
                } else {
                    median = ((long) lower.peek()+ higher.peek()) / 2.0;
                }
                results[index - k] = median;

                if (index < nums.length) {
                    if (nums[index - k] < median) {
                        lower.remove(nums[index - k]);
                        lower.offer(higher.poll());
                    } else {
                        higher.remove(nums[index - k]);
                        higher.offer(lower.poll());
                    }
                }
            }
            if (index < nums.length) {
                higher.offer(nums[index]);
                lower.offer(higher.poll());
                if (higher.size() < lower.size())
                    higher.offer(lower.poll());
            }
        }
        return results;
    }
}
