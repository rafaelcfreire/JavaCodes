package algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

public final class NthFibonacci {
    static Map<Long, Long> memoize = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getNthFibIteractive(99));
//        System.out.println(getNthFibMemoization(35));
        System.out.println(getNthFibMemoization(99));
    }

    public static long getNthFibIteractive(long n) {
        long curr = 1, prev = 0;

        for (long i = curr; i <= n; i++) {
            long temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return prev;
    }

    public static long getNthFibMemoization(long n) {
        if (n == 1 || n == 2)
            return 1;
        else if (memoize.containsKey(Long.valueOf(n)))
            return memoize.get(Long.valueOf(n));
        else {
            long result = getNthFibMemoization(n - 1) + getNthFibMemoization(n - 2);
            memoize.put(Long.valueOf(n), result);
            return result;
        }
    }

    public static long getNthFib(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else
            return getNthFib(n - 1) + getNthFib(n - 2);
    }
}

