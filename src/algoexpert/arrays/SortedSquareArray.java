package algoexpert.arrays;

public class SortedSquareArray {
    public static void main(String[] args) {
//        sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9});
        sortedSquaredArray(new int[]{-7, -5, -4, 3, 6, 8, 9});
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] results = new int[array.length];
        int startPointer = 0, endPointer = array.length - 1, currentPointer = array.length - 1;

        while (startPointer <= endPointer) {
            if (Math.abs(array[startPointer]) > Math.abs(array[endPointer])) {
                results[currentPointer] = array[startPointer] * array[startPointer];
                startPointer++;
            }
            else {
                results[currentPointer] = array[endPointer] * array[endPointer];
                endPointer --;
            }
            currentPointer--;
        }
        return results;
    }
}
