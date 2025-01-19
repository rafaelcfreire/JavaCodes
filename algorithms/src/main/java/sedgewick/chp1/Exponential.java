package sedgewick.chp1;

import edu.princeton.cs.introcs.Stopwatch;

import java.util.Stack;

public final class Exponential {

    public static void main(String[] args) {
//        Stopwatch timer = new Stopwatch();
//        System.out.println(exponentialIterative(2, 3));
//        System.out.println("Time: "+timer.elapsedTime());

        Stopwatch timer2 = new Stopwatch();
        System.out.println(exponentialRecursive(3, 4));
        System.out.println("Time 2: "+timer2.elapsedTime());
//
//        Stopwatch timer3 = new Stopwatch();
//        System.out.println(exponentialRecursive2(2, 100));
//        System.out.println("Time 3: "+timer3.elapsedTime());

        System.out.println(exponentWithPowerOfRule(3, 4));
    }

    public static long exponentialIterative(long n, long a) {
        long result = n;

        for (long i = 1; i < a; i++) {
            result *= n;
        }
        return result;
    }

    public static long exponentialRecursive(long n, long a) {
        if (a == 0)
            return 0;
        else if (a == 1)
            return n;
        else if (a % 2 == 0) {
            long result = exponentialRecursive(n, a / 2);
            return result * result;
        } else {
            long result = exponentialRecursive(n, a / 2);
            return result * result * n;
        }
    }

    public static long exponentialRecursive2(long n, long a) {
        if (a == 0)
            return 1;
        else if (a == 1)
            return n;
        else
            return n * exponentialRecursive2(n, a - 1);
    }

    // Iterative way dividing the value to reduce the amount of operations
    public static long exponentWithPowerOfRule(long n, long a) {
        Stack<String> opStack = new Stack<>();
        while (a > 1) {
            if (a % 2 == 0) {
                opStack.add("square");
                a = a / 2;
            } else if (a % 2 == 1) {
                a -= 1;
                opStack.add("multiply");
            }
        }
        long result = n;
        while (!opStack.empty()) {
            String op = opStack.pop();
            if (op.equals("multiply"))
                result  *= n;
            else if (op.equals("square"))
                result *= result;
        }
        return result;
    }
}
