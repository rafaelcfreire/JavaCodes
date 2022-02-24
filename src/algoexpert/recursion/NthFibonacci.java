package algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {
    static Map<Long, Long> memoize = new HashMap<>();

    public static void main(String[] args) {
//        System.out.println(getNthFibIteractive(35));
//        System.out.println(getNthFibMemoization(35));
        System.out.println(getNthFib(2));
    }

    public static long getNthFibIteractive(int n) {
        long currentNumberOfWays = 0;
        long[] slidingWindow = new long[n];
        slidingWindow[0] = 0;
        slidingWindow[1] = 1;

        for(int currentIndex = 2; currentIndex < n; currentIndex++) {
            int startOfWindow = currentIndex - 3;
            int endOfWindow = currentIndex - 1;

            if(startOfWindow >= 0) {
                currentNumberOfWays -= slidingWindow[startOfWindow];
            }
            currentNumberOfWays += slidingWindow[endOfWindow];
            slidingWindow[currentIndex] = currentNumberOfWays;
        }
        return slidingWindow[n - 1];
    }

    public static long getNthFibMemoization(int n) {
        if(n == 1)
            return 0;
        else if(n == 2)
            return 1;
        else if(memoize.containsKey(Long.valueOf(n)))
            return memoize.get(Long.valueOf(n));
        else {
            long result = getNthFibMemoization(n - 1) + getNthFibMemoization(n - 2);
            memoize.put(Long.valueOf(n), result);
            return result;
        }
    }

    public static long getNthFib(int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return getNthFib(n - 1) + getNthFib(n - 2);
    }
}

