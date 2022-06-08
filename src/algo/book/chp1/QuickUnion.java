package algo.book.chp1;

import algo.book.common.In;
import algo.book.common.StdOut;
import algo.book.common.Stopwatch;

public class QuickUnion {
    private int id[];
    private int count;

    public QuickUnion(int n){
        id = new int[n];
        count = n;

        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;
        id[i] = j;
        count--;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] whitelist = In.readInts(args[0]);
        int n = whitelist[0];
        QuickUnion quickUnion = new QuickUnion(n);
        for(int i = 1; i < whitelist.length; i+=2) {
            int p = whitelist[i];
            int q = whitelist[i + 1];
            if(quickUnion.find(p) == quickUnion.find(q))
                continue;
            quickUnion.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.printf("Elapsed Time: %5.1f\n", timer.elapsedTime());
    }
}
