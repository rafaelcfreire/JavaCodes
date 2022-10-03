package algo.book.chp2;

import algo.book.common.StdOut;
import algo.book.common.Stopwatch;

public final class BottomUpMergeSort {
    private static Comparable[] aux;
    private static int counter = 0;

    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];

        for(int len = 1; len < n; len *= 2)
            for(int lo = 0; lo < n - len; lo += len+len)
                merge(a, lo, lo+len - 1, Math.min(lo+len+len-1, n - 1));
    }

    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    /*
    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int middle = lo + (hi - lo)/2;
        sort(a, lo, middle);
        sort(a, middle + 1, hi);
        merge(a, lo, middle, hi);
    }
     */

    private static void merge(Comparable[] a, int lo, int middle, int hi) {
        int i = lo, j = middle + 1;

        for(int k = 0; k < a.length; k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++){
            if(i > middle) {
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])) {
                counter += 1;
                a[k] = aux[j++];
            }
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
//        Comparable[] array = {'E', 'E', 'G', 'M', 'R', 'A', 'C', 'E', 'R', 'T'};
//        int MAX = 100000;
//        int N = 100000;
//        Integer[] array = new Integer[N];
//        for (int i = 0; i < N; i++)
//            array[i] = StdRandom.uniform(0, MAX);
        Comparable[] a = {7, 5, 3, 1};
        Stopwatch timer = new Stopwatch();
        sort(a);
        for(int c = 0; c < a.length; c++)
            StdOut.print(a[c]+ " ");
        System.out.println("Counter: "+counter);
        System.out.println("Time: "+timer.elapsedTime());
    }
}