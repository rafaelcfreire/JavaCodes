package algo.book.chp2;

import algo.book.common.StdOut;
import algo.book.common.StdRandom;
import algo.book.common.Stopwatch;

public class ShellSort {

    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a){
        int n = a.length;

        int h = 1;
        while(h < n/3)
            h = h*3 + 1;
        while(h >= 1) {
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exchange(a, j, j - h);
                }
            }
            h = h/3;
        }
    }

    public static void exchange(Comparable[] a, int i, int j) {
        /*
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
**/
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i]+ " ");
        StdOut.println();
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
