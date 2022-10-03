package algoexpert.stack;

import java.util.Stack;

public final class NextGreaterElement {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{2, 5, -3, -4, 6, 7, 2});
    }

    public static int[] nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = -1;

        for (int i = 0; i < array.length * 2; i++) {
            int temp = i >= array.length ? i % array.length : i;

            while (!stack.empty()) {
                if (array[temp] > array[stack.peek()]) {
                    int curr = stack.pop();
                    result[curr] = array[temp];
                } else break;
            }
            stack.push(temp);
        }

        return result;
    }
}
