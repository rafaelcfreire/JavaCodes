package algoexpert.arrays;

import java.util.Arrays;
import java.util.Map;

import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] value = new int[]{3, 5, 5, 8, 11, 1, -1, 6};
        twoNumberSum(value, 10);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Long> mapValues = Arrays.stream(array).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int current : array) {
            if (mapValues.containsKey(targetSum - current) && mapValues.get(targetSum - current) > 0) {
                if (targetSum - current == current && mapValues.get(targetSum - current) > 1)
                    return new int[]{current, current};
                if (current != targetSum - current)
                    return new int[]{current, targetSum - current};
            }
        }
        return new int[0];
    }
















//    public static int[] twoNumberSum(int[] array, int targetSum) {
//        Map<Integer, Long> collection = Arrays.stream(array).boxed()
//                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
//
//        for(int current : array) {
//            if(collection.containsKey(targetSum - current) && collection.get(targetSum - current) > 0) {
//                if(current == targetSum - current && collection.get(targetSum - current) > 1)
//                    return new int[]{current, targetSum - current};
//                if(current != targetSum - current)
//                    return new int[]{current, targetSum - current};
//            }
//        }
//        return new int[0];
//    }

}
