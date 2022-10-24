package leetcode.recursion;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/permutation-in-string/
public final class PermutationInString {
    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidbaooo");
    }

    public static boolean checkInclusion(String s1, String s2) {
        Set<String> permutations = new HashSet<>();

        helper(s1, "", permutations);

        for (String cur : permutations) {
            if (s2.contains(cur))
                return true;
        }
        return false;
    }

    private static void helper(String originalStr, String permutation, Set<String> permutations) {
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
