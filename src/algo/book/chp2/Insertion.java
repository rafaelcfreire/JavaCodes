package algo.book.chp2;

import algo.book.common.StdDraw;

public class Insertion extends Example {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int lb = i;// Record insertion position Leftboard
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                lb = j - 1;
            }
            draw(a, lb, i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StdDraw.clear();
        }
        draw(a, N, N);
    }

    /**
     * Visualization
     * Each time you insert, the swap position is black, the current data update location is red, the rest is gray
     * @Param a Sort array
     * @Param LB Current plug-in left boundary
     * @Param RB Current plunger row right border
     */
    public static void draw(Comparable[] a, int lb, int rb) {
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

    public static void main(String[] args) {
//        String[] a = In.readStrings();

        Comparable[] a = new Comparable[100];
        for (int i = 0; i < 100; i++) {
            a[i] = Math.random();
        }
        sort(a);
        assert isSorted(a);
//        show(a);
    }
}