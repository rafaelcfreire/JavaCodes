package algoexpert.sorting;

public class CountInversions {
    private static int inversions;
    public static void main(String[] args) {
        //        int[] value = new int[]{69, 69, 71, 77, 82, 65, 67, 69, 82, 84};
//        int[] value = new int[]{8, 5, 2, 9, 5, 6, 3};
//        int[] value = new int[]{2, 3, 3, 1, 9, 5, 6};
//        int[] value = new int[]{1, 5, 3, 7};
        int[] value = new int[]{3, 4, 1, 2};

        System.out.println(countInversions(value));
    }

    private static int countInversions(int[] array) {
        inversions = 0;
        sort(array, 0, array.length - 1);
        return inversions;
    }

    private static void sort(int[] array, int low, int high) {
        if(high <= low)
            return;
        int middle = low + (high - low) / 2;
        sort(array, low, middle);
        sort(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        int i = low, j = middle + 1;

        for(int k = j; k <= high; k++) {
            for(int l = i; l <= middle; l++) {
                if(array[k] < array[l]) {
                    inversions += 1;
                }
            }
        }
    }

}





