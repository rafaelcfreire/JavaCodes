package book.chp1;

import book.common.In;
import book.common.StdIn;
import book.common.StdOut;

import java.util.Arrays;

public final class BinarySearch {
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;

        while(low <= high) {
            int middle = low + (high - low) / 2;
            if(key < middle)
                high = middle - 1;
            if(key > middle)
                low = middle + 1;
            else return middle;
        }
        return -1;
    }
}
