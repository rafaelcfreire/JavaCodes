package book.chp2;

import edu.princeton.cs.introcs.StdDraw;

public final class InsertionBaseSort extends IntegerSortAlgorithm {
    private static int counter = 0;

    @Override
    public void sort(final Integer[] a) {
        int n = a.length;

        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j, j - 1);
                counter += 1;
            }
        }
    }

    public void draw(int[] a, int lb, int rb) {
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

    public void exchange(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}