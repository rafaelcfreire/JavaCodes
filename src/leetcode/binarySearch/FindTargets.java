package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class FindTargets {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 2, 3};

        List<Integer> result = targetIndices(nums, 5);
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> results = new ArrayList<>();
        int low = 0, high = nums.length - 1;
        Arrays.sort(nums);

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                if (nums.length == 1 && nums[middle] == target) {
                    results.add(middle);
                } else {
                    while (middle != 0 && nums[middle - 1] == target) {
                        middle -= 1;
                    }
                    while (middle <= high && nums[middle] == target) {
                        results.add(middle);
                        middle += 1;
                    }
                }
                return results;
            }
        }
        return List.of();
    }
}
