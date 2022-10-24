package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PermutationII {

    public static void main(String[] args) {
        List<List<Integer>> result = getPermutations(4);
    }

    public static List<List<Integer>> getPermutations(int number) {
        List<List<Integer>> permutations = new ArrayList<>();

        helper(IntStream.rangeClosed(1, number).boxed().collect(Collectors.toList()), new ArrayList<>(), permutations);

        return permutations;
    }

    private static void helper(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                helper(newArray, newPermutation, permutations);
            }
        }
    }
    // Stream.iterate(index, n -> n+1).limit(number).collect(Collectors.toList())
}
