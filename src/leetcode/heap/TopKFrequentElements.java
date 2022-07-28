package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        //int[] result = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        int[] result = topKFrequent(new int[]{3,0,1,0}, 1);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(nums);

        int l = 0, j = 1;
        while (j < nums.length) {
            if (nums[l] != nums[j]) {
                maxPQ.add(new Pair(nums[l], j - l));
                l = j;
            }
            j++;
        }
        maxPQ.add(new Pair(nums[l], j - l));

        for (int i = 0; i < k; i++)
            result[i] = maxPQ.poll().value;

        return result;
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        Integer frequency;

        public Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair other) {
            return this.frequency - other.frequency;
        }
    }
}

