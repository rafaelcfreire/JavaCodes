package algoexpert.arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int highestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {

            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                int currentPeak = 1;
                int leftPointer = i, rightPointer = i;

                while (leftPointer > 0 && array[leftPointer] > array[--leftPointer])
                    currentPeak++;
                while (rightPointer < array.length - 1 && array[rightPointer] > array[++rightPointer])
                    currentPeak++;

                if (currentPeak > highestPeak)
                    highestPeak = currentPeak;
            }
        }
        return highestPeak;
    }

    public static void main(String[] args) {
        longestPeak(new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3});
//        longestPeak(new int[] {});
//        longestPeak(new int[] {1, 3, 2});
//        longestPeak(new int[] {1, 2, 3, 4, 5, 1});
//        longestPeak(new int[] {5, 4, 3, 2, 1, 2, 1});
//        longestPeak(new int[] {5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10});
//        longestPeak(new int[] {5, 4, 3, 2, 1, 2, 10, 12});
//        longestPeak(new int[] {1, 2, 3, 4, 5, 6, 10, 100, 1000});
//        longestPeak(new int[] {1, 2, 3, 3, 2, 1});
//        longestPeak(new int[] {1, 1, 3, 2, 1});
//        longestPeak(new int[] {1, 2, 3, 2, 1, 1});
//        longestPeak(new int[]{1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1});
//        longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10});
    }
}
