package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        threeNumberSumOptimized(array, 0);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int l = j + 1; l < array.length; l++) {
                    if (array[i] + array[j] + array[l] == targetSum)
                        results.add(new Integer[]{array[i], array[j], array[l]});
                }
            }
        }
        return results;
    }

    public static List<Integer[]> threeNumberSumOptimized(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    results.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                }
            }
        }
        return results;
    }
}
