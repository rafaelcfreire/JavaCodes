package algoexpert.sorting;

public final class MergeSort {
    private static int[] aux;

    public static void main(String[] args) {
//        int[] value = new int[]{69, 69, 71, 77, 82, 65, 67, 69, 82, 84};
        int[] value = new int[]{8, 5, 2, 9, 5, 6, 3};
//        int[] value = new int[]{2, 3, 3, 1, 9, 5, 6};
        mergeSort(value);
    }

    public static void mergeSort(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (high <= low)
            return;
        int middle = low + (high - low) / 2;
        sort(array, low, middle);
        sort(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        int left = low, right = middle + 1;

        for (int i = low; i <= high; i++)
            aux[i] = array[i];

        for (int i = low; i <= high; i++) {
            if (middle < left)
                array[i] = aux[right++];
            else if (high < right)
                array[i] = aux[left++];
            else if (aux[left] < aux[right])
                array[i] = aux[left++];
            else
                array[i] = aux[right++];
        }
    }
}









//    public static void mergeSort(int[] array) {
//        aux = new int[array.length];
//        sort(array, 0, array.length - 1);
//    }
//
//    private static void sort(int[] array, int low, int high) {
//        if (high <= low)
//            return;
//        int middle = low + (high - low) / 2;
//        sort(array, low, middle);
//        sort(array, middle + 1, high);
//        merge(array, low, middle, high);
//    }
//
//    private static void merge(int[] array, int low, int middle, int high) {
//        int left = low, right = middle + 1;
//
//        for (int i = low; i <= high; i++)
//            aux[i] = array[i];
//
//        for (int i = low; i <= high; i++) {
//            if (left > middle)
//                array[i] = aux[right++];
//            else if (right > high)
//                array[i] = aux[left++];
//            else if (aux[left] < aux[right])
//                array[i] = aux[left++];
//            else
//                array[i] = aux[right++];
//        }
//    }
//}