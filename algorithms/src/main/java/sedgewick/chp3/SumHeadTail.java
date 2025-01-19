package sedgewick.chp3;

import java.util.Arrays;

public final class SumHeadTail {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{5, 2, 4, 8}));
    }

    public static int sum(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        int head = numbers[0];
        int[] tail = Arrays.copyOfRange(numbers, 1, numbers.length);
        return head + sum(tail);
    }
}
