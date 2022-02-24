package epam;

public class Fibonacci {
    public static void main(String[] args) {
        printFibonnaci(6);
        System.out.println("\n");
//        printFibonacciRecursively(5);
    }

    public static void printFibonnaci(int n) {
        int prev = 0, current = 1;

        for (int i = current; i <= n; i++) {
            int next = current + prev;
            System.out.print(current+", ");
            prev = current;
            current = next;
        }
    }

    public static void printFibonacciRecursively(long n) {
        printFibonacciRecursively(n, 0, 0, 1);
    }

    private static void printFibonacciRecursively(long n, long i, long prev, long current) {
        if (n <= i)
            return;
        System.out.print(current+", ");
        printFibonacciRecursively(n, i + 1, current, current + prev);
    }
}
