package epam;

public final class Fibonacci {
    public static void main(String[] args) {
        printFibonacci(85);
        System.out.println("\n");
        printFibonacciRecursively(85);
    }

    public static void printFibonacci(long n) {
        long prev = 0, curr = 1;

        for (long i = curr; i <= n; i++) {
            System.out.print(i == n ? curr : curr+", ");
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
    }

    public static void printFibonacciRecursively(long n) {
        printFibonacciRecursively(n, 0, 0, 1);
    }

    private static void printFibonacciRecursively(long n, long i, long prev, long curr) {
        if (i == n)
            return;
        System.out.print(i == n - 1 ? curr : curr+", ");
        printFibonacciRecursively(n, i + 1, curr, curr + prev);
    }
}
