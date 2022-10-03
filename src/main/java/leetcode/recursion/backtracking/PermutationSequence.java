package leetcode.recursion.backtracking;

// https://leetcode.com/problems/permutation-sequence/
// DID NOT PASS
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PermutationSequence {
    public static void main(String[] args) {
        System.out.print(getPermutation(9, 196883));
    }

    public static String getPermutation(int n, int k) {
        List<String> permutations = new ArrayList<>();

        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        getPermutations(list, "", permutations);

        return permutations.get(k - 1);
    }

    private static void getPermutations(List<Integer> values, String currentPermutation, List<String> permutations) {
        if (values.size() == 0 && currentPermutation.length() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < values.size(); i++) {
                List<Integer> newValues = new ArrayList<>(values);
                int temp = newValues.remove(i);
                String newPermutation = currentPermutation + temp;
                getPermutations(newValues, newPermutation, permutations);
            }
        }
    }
}



//        if (n == 0 && currentPermutation.length() > 0) {
//                permutations.add(currentPermutation);
//                } else {
//                for (int i = 0; i < n; i++) {
//        int newN = n - 1;
//        if (currentPermutation.isEmpty()) {
//        currentPermutation = "1";
//        } else {
//        int newCurrent = Integer.parseInt(currentPermutation.substring(currentPermutation.length() - 1)) + 1;
//        currentPermutation += newCurrent;
//        }
//        getPermutations(newN, currentPermutation, permutations);
//        }
//        }
