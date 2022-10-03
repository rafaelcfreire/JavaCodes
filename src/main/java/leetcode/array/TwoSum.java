package leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/problems/two-sum/
public final class TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15}, 9);
        twoSum(new int[]{3,3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        AtomicInteger index = new AtomicInteger();
        Map<Integer, Integer> items = Arrays.stream(nums)
                .boxed().collect(Collectors.toMap(Function.identity(), s -> index.getAndIncrement(), (a, b) -> b));

        for (int i = 0; i < nums.length; i++) {
            if (items.containsKey(target - nums[i]) && items.get(target - nums[i]) != i) {
                return new int[]{i, items.get(target - nums[i])};
            }
        }
        return new int[]{};
    }
}
