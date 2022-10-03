package algo.book.chp2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

public final class InsertionSort {
    private static int counter = 0;
    public static void sort(Comparable[] a) {
        int n = a.length;

        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exchange(a, j, j - 1);
                counter += 1;
            }
        }
    }

    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void draw(int[] a, int lb, int rb) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = (double) a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = (double) a[i] / 2.0;
            if (i == lb) {                                //red
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(x, y, rw, rh);
            } else if (lb < i && i <= rb) {               //black
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(x, y, rw, rh);
            } else {                                     //gray
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.filledRectangle(x, y, rw, rh);
            }
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
        int MAX = 100000;
        int N = 100000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, MAX);
        Stopwatch timer = new Stopwatch();
        sort(a);
        show(a);
        System.out.println("Counter: "+counter);
        System.out.println("Time: "+timer.elapsedTime());
    }

}
