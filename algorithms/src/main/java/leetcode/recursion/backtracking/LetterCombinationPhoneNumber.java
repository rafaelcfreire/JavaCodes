package leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public final class LetterCombinationPhoneNumber {

    public static void main(String[] args) {
        letterCombinations("abcdef");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> permutations = new ArrayList<>();

        helper(digits, "", permutations);

        return permutations;
    }

    private static void helper(String digits, String permutation, List<String> permutations) {
        if (digits.length() == 0 && permutation.length() > 0) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i < digits.length(); i++) {
                String newDigits = digits;
                newDigits = (i == 0) ? newDigits.substring(1) : newDigits.substring(0, i) + newDigits.substring(i + 1);
                String newPermutation = permutation + digits.charAt(i);
                helper(newDigits, newPermutation, permutations);
            }
        }
    }
}
