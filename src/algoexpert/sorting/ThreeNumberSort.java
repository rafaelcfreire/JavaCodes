package algoexpert.sorting;

public class ThreeNumberSort {
    public static void main(String[] args) {
        threeNumberSort(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1});
//        threeNumberSort(new int[]{7, 8, 9, 7, 8, 9, 9, 9, 9, 9, 9, 9}, new int[]{8, 7, 9});
    }

    public static int[] threeNumberSort(int[] array, int[] sort) {
        int firstValue = sort[0], secondValue = sort[1];
        int firstIndex = 0, secondIndex = 0, thirdIndex = array.length - 1;

        while(secondIndex <= thirdIndex) {
            int value = array[secondIndex];

            if(value == firstValue)
                exchange(array, firstIndex++, secondIndex++);
            else if(value == secondValue)
                secondIndex++;
            else
                exchange(array, secondIndex, thirdIndex--);
        }
        return array;
    }

    public static int[] threeNumberSortTwoPasses(int[] array, int[] sort) {
        int firstValue = sort[0], thirdValue = sort[2];
        int firstIndex = 0, lastIndex = array.length - 1;

        for(int j = 0; j < array.length; j++) {
            if(array[j] == firstValue)
                exchange(array, j, firstIndex++);
        }
        for(int k = array.length - 1; k > 0; k--) {
            if(array[k] == thirdValue)
                exchange(array, k, lastIndex--);
        }
        return array;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
