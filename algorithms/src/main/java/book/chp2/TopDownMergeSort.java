package book.chp2;

import book.common.StdOut;
import book.common.StdRandom;
import book.common.Stopwatch;

public final class TopDownMergeSort {
    private static Comparable[] aux;
    private static int counter = 0;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int low, int middle, int high) {
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

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        /*
        Comparable[] array = {'E', 'E', 'G', 'M', 'R', 'A', 'C', 'E', 'R', 'T'};
        merge(array, 0, array.length - 1 / 2, array.length - 1);
         */
        int MAX = 100000;
        int N = 100000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, MAX);

        Stopwatch timer = new Stopwatch();
        sort(a);
        for(int c = 0; c < a.length; c++)
            StdOut.print(a[c]+ " ");
        System.out.println("Counter: "+counter);
        System.out.println("Time: "+timer.elapsedTime());
    }
}
