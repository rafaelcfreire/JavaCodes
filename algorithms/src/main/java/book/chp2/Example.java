package book.chp2;

import book.common.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-23
 * A sort template allows the sort algorithm to inherit
 */
public class Example {

    /**
     * Sort method
     * @param a
     */
    public static void sort(Comparable[] a){}

    /**
     * Element comparison, V is less than W
     * @param v
     * @param w
     * @return
     */
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * Element exchange, or habits SWAP
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] a, int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Print the current array
     * @param a
     */
    protected static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * Judging whether the array is in order
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}