package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public final class PermutationString {
    public static void main(String[] args) {
        List<String> results = permutations("ab");
    }

    public static List<String> permutations(String originalStr) {
        List<String> permutations = new ArrayList<>();

        helper(originalStr, "", permutations);

        return permutations;
    }

    private static void helper(String originalStr, String permutation, List<String> permutations) {
        if (originalStr.length() == 0 && permutation.length() > 0) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i < originalStr.length(); i++) {
                String newStr = originalStr;
                newStr = i == 0 ? newStr.substring(1) : newStr.substring(0, i) + newStr.substring(i + 1);
                String newPermutation = permutation + originalStr.charAt(i);
                helper(newStr, newPermutation, permutations);
            }
        }
    }
}
