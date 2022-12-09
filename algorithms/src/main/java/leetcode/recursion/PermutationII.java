package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations-ii/
public final class PermutationII {
    public static void main(String[] args) {
        permuteUnique(new int[] {1, 1, 2});
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            numsList.add(nums[i]);

        permuteUnique(numsList, new ArrayList<>(), permutations);

        return permutations.stream().collect(Collectors.toList());
    }

    private static void permuteUnique(List<Integer> array, List<Integer> currentPermutation, Set<List<Integer>> permutations) {
        if (array.isEmpty() && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                permuteUnique(newArray, newPermutation, permutations);
            }
        }
    }
}
