package algo.book.chp2;

import algo.book.common.StdOut;
import algo.book.common.StdRandom;
import algo.book.common.Stopwatch;

public class QuickSort {
    static int counter = 0;

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while(true){
         while(less(a[++i], v))
             if(i == hi)
                 break;
         while(less(v, a[--j]))
             if(j == lo)
                 break;
         if(i >= j)
             break;
         exch(a, i, j);
         counter += 1;
        }
        exch(a, lo, j);
        counter += 1;
        return j;
    }

    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
//        int MAX = 500000;
//        int N = 500000;
//        Integer[] a = new Integer[N];
//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform(0, MAX);
        Comparable[] a = {2, 5, 3, 1};
        Stopwatch timer = new Stopwatch();
        sort(a);
        for(int c = 0; c < a.length; c++)
            StdOut.print(a[c]+ " ");
        System.out.println("Time: "+timer.elapsedTime());
        System.out.println("Counter: "+counter);
    }
}
