package epam;

public final class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        printFibonacci(85);
        long finish = System.currentTimeMillis() - startTime;
        System.out.println("finish time: "+finish);

        System.out.println("\n");
        long startTimeRecursiveAlgo = System.currentTimeMillis();
        printFibonacciRecursively(85);
        long finishRecursiveAlgo = System.currentTimeMillis() - startTimeRecursiveAlgo;
        System.out.println("finish time: "+finishRecursiveAlgo);
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
