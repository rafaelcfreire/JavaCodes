package algoexpert.arrays;

import java.util.HashSet;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        firstDuplicateValue(new int[] {2, 1, 5, 2, 3, 3, 4});
    }

    private static int firstDuplicateValue(int[] array) {
        for (int current : array) {
            int absValue = Math.abs(current);
            if (array[absValue - 1] < 0)
                return absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }

    private static int firstDuplicatedValueBruteForce(int[] array) {
        int returnValue = -1;

        for(int j = 0; j < array.length; j++) {
            for(int k = j + 1; k < array.length; k++) {
                if(array[k] == array[j]) {
                    returnValue = array[k];
                    return returnValue;
                }
            }
        }

        return returnValue;
    }

    private static int firstDuplicatedValueUsingSet(int[] array) {
        HashSet<Integer> seenValues = new HashSet<>();
        for(int value : array) {
            if(seenValues.contains(value))
                return value;
            else
                seenValues.add(value);
        }
        return -1;
    }
}