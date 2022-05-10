package algoexpert.sorting;

//https://stackoverflow.com/questions/159590/way-to-go-from-recursion-to-iteration

public class QuickSort {
    public static void main(String[] args) {
        int[] value = new int[] {-1, 5, 10, 20, 28, 3};
//        int MAX = 500000;
//        int N = 500000;
//        int[] value = new int[N];
//        for (int i = 0; i < N; i++)
//            value[i] = StdRandom.uniform(0, MAX);
        quickSort(value);
        System.out.println(value);
    }

    public static void quickSort(int[] value) {
        sort(value, 0, value.length);
    }

    private static void sort(int[] value, int low, int high) {
        if (high <= low)
            return;
        int pivotIdx = partition(value, low, high);
        sort(value, low, pivotIdx - 1);
        sort(value, pivotIdx + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int left = low, pivotIdx = low, right = high;

        while (true) {
            while (array[left++] < array[pivotIdx]) {
                if (left == high)
                    break;
            }
            while (array[--right] > array[pivotIdx]) {
                if (right == low)
                    break;
            }
            if (right <= left)
                break;
            exchange(array, left, right);
        }
        exchange(array, pivotIdx, right);
        return right;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
