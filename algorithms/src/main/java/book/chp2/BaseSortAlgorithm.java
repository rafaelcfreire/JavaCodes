package book.chp2;

import book.common.StdOut;
import book.common.Stopwatch;

abstract class BaseSortAlgorithm<T extends Number> {

    public void triggerSort() {
        Stopwatch timer = new Stopwatch();
        T[] a = getRandomNumbers();
        sort(a);
        show(a);
        System.out.println("Time: "+timer.elapsedTime());
    }

    public void show(T[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i]+ " ");
        StdOut.println();
    }

    abstract void sort(T[] a);

    abstract T[] getRandomNumbers();

    abstract boolean less(T v,T w);
}
