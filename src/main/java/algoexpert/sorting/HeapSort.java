package algoexpert.sorting;

public final class HeapSort {
    public static void main(String[] args) {
        heapSort(new int[]{8, 5, 2, 9, 5, 6, 3});
//        int MAX = 500000;
//        int N = 500000;
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform(0, MAX);
//        Stopwatch timer = new Stopwatch();
//        heapSort(a);
//        show(a);
//        System.out.println("Time: "+timer.elapsedTime());
    }

    public static int[] heapSort(int[] array) {
        int n = array.length - 1;

        for (int i = n / 2; i >= 0; i--)
            sink(array, i, n);
        while (n >= 1) {
            exchange(array, 0, n--);
            sink(array, 0, n);
        }
        return array;
    }

    private static void sink(int[] array, int currentIdx, int endIx) {
        int childOne = currentIdx * 2 + 1;

        while (childOne <= endIx) {
            int childTwo = currentIdx * 2 + 2 <= endIx ? currentIdx * 2 + 2 : -1;
            int indexToSwap;

            if (childTwo != -1 && array[childTwo] > array[childOne]) {
                indexToSwap = childTwo;
            } else {
                indexToSwap = childOne;
            }

            if (array[currentIdx] < array[indexToSwap]) {
                exchange(array, currentIdx, indexToSwap);
                currentIdx = indexToSwap;
                childOne = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
//    public static void show(int[] a){
//        for(int i = 0; i < a.length; i++)
//            StdOut.print(a[i]+ " ");
//        StdOut.println();
//    }
}
