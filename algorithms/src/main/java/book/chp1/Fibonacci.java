package book.chp1;

public final class Fibonacci {

    public static void main(String[] args) {
        int[] result = fibonacciIterative(6);
    }

    public static int[] fibonacciIterative(int number) {
        int current = 1, prev = 0;
        int[] result = new int[number];

        for (int i = 0; i < number; i++) {
            result[i] = current;
            int temp = current;
            current = current + prev;
            prev = temp;
        }
        return result;
    }
}
