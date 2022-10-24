package book.chp2;

import book.common.StdOut;
import book.common.StdRandom;
import book.common.Stopwatch;

public final class SelectionSort {
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i]+ " ");
        StdOut.println();
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int MAX = 1000;
        int N = 1000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, MAX);
        Stopwatch timer = new Stopwatch();
        sort(a);
        show(a);
        System.out.println("Time: "+timer.elapsedTime());
    }
}
