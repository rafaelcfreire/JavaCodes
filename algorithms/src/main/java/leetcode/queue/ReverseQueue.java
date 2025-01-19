package leetcode.queue;

import java.util.Stack;

final class ReverseQueue {
    public static void main(String[] args) {
        int[] queue = new int[]{1, 2, 3, 4, 5, 6};
        int[] result = reverseQueue(queue);
        System.out.println(result);
    }

    private static int[] reverseQueue(final int[] queue) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[queue.length];

        for (int curr : queue) {
            stack.add(curr);
        }
        for (int i = 0; i < queue.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}