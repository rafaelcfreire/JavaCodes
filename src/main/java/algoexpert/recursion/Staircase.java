package algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

public final class Staircase {
    static Map<Integer, Integer> memoize = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(stepPerms(7));
        System.out.println(staircaseTraversal(4, 2));
    }

    public static int staircaseTraversal(int height, int maxSteps) {
        int currentNumberOfWays = 0;
        int[] slidingWindow = new int[height + 1];
        slidingWindow[0] = 1;

        for(int currentIndex = 1; currentIndex <= height; currentIndex++) {
            int startOfWindow = currentIndex - maxSteps - 1;
            int endOfWindow = currentIndex - 1;

            if(startOfWindow >= 0) {
                currentNumberOfWays -= slidingWindow[startOfWindow];
            }
            currentNumberOfWays += slidingWindow[endOfWindow];
            slidingWindow[currentIndex] = currentNumberOfWays;
        }
        return slidingWindow[height];
    }

    public static int stepPerms(int n) {
        if(n == 0 || n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else if(memoize.containsKey(n))
            return memoize.get(n);
        else {
            int value = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
            memoize.put(n, value);
            return value;
        }
    }
}
