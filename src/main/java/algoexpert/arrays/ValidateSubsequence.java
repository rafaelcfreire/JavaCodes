package algoexpert.arrays;

import java.util.List;

public final class ValidateSubsequence {
    public static void main(String[] args) {
//        isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10));
//        isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(4, 5, 1, 22, 25, 6, -1, 8, 10));
//        isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 23, 6, -1, 8, 10));
        isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(22, 25, 6));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        boolean isValid = false;
        int sequenceIndex = 0;

        for(int k = 0; k < array.size(); k++) {
            if(sequenceIndex < sequence.size() && array.get(k) == sequence.get(sequenceIndex)) {
                if(sequenceIndex == sequence.size() - 1)
                    isValid = true;
                sequenceIndex++;
            }
        }
        return isValid;
    }
}
