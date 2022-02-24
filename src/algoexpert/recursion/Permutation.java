package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        List<List<Integer>> result = getPermutations(values);
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();

        getPermutationsOptimized(0, array, permutations);

        return permutations;
    }

    public static void getPermutationsOptimized(int index, List<Integer> array, List<List<Integer>> permutations) {
        if (index == array.size() - 1) {
            permutations.add(array);
        } else {
            for (int i = index; i < array.size(); i++) {
                exchange(array, index, i);
                getPermutationsOptimized(index + 1, array, permutations);
                exchange(array, index, i);
            }
        }
    }

    private static void exchange(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
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
