package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public final class Permutation {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        List<List<Integer>> result = getPermutations(values);
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();

        permutationHelper(array, new ArrayList<>(), permutations);

        return permutations;
    }

    public static void permutationHelper(List<Integer> array, List<Integer> currentPermutation,
                                         List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                permutationHelper(newArray, newPermutation, permutations);
            }
        }
    }

}



//        if (index == array.size() - 1) {
//                permutations.add(new ArrayList<>(array));
//        } else {
//        for (int j = index; j < array.size(); j++) {
//        exchange(array, index, j);
//        getPermutationsOptimized(index + 1, array, permutations);
//        exchange(array, index, j);
//        }
//        }
