package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
public final class ClimbingStairs {
    private static Map<Integer, Integer> memoize = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        else if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            memoize.put(n, result);
            return result;
        }
    }
}
