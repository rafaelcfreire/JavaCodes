package leetcode.priorityqueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/minimum-number-game/description/
final class MinimumNumberGame {
    public static void main(String[] args) {
        //IntStream.range(1, 101).forEach(System.out::println);
        new MinimumNumberGame().numberGame(new int[]{5,4,2,3});
    }

    public int[] numberGame(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(list);
        int[] newNums = new int[nums.length];

        boolean isBobTurn;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                isBobTurn = true;
            } else {
                isBobTurn = false;
            }
            newNums[i] = priorityQueue.poll();

            if (isBobTurn) {
                exchange(newNums, i - 1, i);
            }
        }
        return newNums;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}