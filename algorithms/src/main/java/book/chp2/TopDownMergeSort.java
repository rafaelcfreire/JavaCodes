package book.chp2;

import book.common.StdOut;
import book.common.StdRandom;
import book.common.Stopwatch;

public final class TopDownMergeSort extends IntegerSortAlgorithm {
    private static int counter = 0;
    private Integer[] aux;

    @Override
    void sort(final Integer[] a) {
        aux = new Integer[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Integer[] a, int lo, int hi) {
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    void merge(Integer[] a, int low, int middle, int high) {
        int i = low, j = middle + 1;

        for(int k = low; k <= high; k++)
            aux[k] = a[k];

        for(int k = low; k <= high; k++){
            if(i > middle)
                a[k] = aux[j++];
            else if(j > high)
                a[k] = aux[i++];
            else if(less(aux[j], aux[i])){
                counter += 1;
                a[k] = aux[j++];
            }
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        TopDownMergeSort topDownMergeSort = new TopDownMergeSort();
        topDownMergeSort.triggerSort();
    }
}