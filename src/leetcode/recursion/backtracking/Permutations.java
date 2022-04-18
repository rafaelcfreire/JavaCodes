package leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/permutations/
public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        helper(IntStream.of(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), permutations);

        return permutations;
    }

    private static void helper(List<Integer> l1, List<Integer> permutation, List<List<Integer>> permutations) {
        if (l1.size() == 0 && permutation.size() > 0) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i < l1.size(); i++) {
                List<Integer> newList = new ArrayList<>(l1);
                newList.remove(i);
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(l1.get(i));
                helper(newList, newPermutation, permutations);
            }
        }
    }

}
