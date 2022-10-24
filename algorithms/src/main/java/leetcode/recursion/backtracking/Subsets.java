package leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

// [0] [1] [2] [1,2] [3] [1,3] [2,3] [1,2,3]
// https://leetcode.com/problems/subsets/
public final class Subsets {

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> supersets = new ArrayList<>();
        supersets.add(List.of());

        for (int curr : nums) {
            int setSize = supersets.size();

            for (int i = 0; i < setSize; i++) {
                List<Integer> newList = new ArrayList<>(supersets.get(i));
                newList.add(curr);
                supersets.add(newList);
            }
        }
        return supersets;
    }
}
