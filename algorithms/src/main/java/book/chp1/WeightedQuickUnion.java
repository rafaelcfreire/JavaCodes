package book.chp1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

public final class WeightedQuickUnion {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnion(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] whitelist = In.readInts(args[0]);
        int n = whitelist[0];
        WeightedQuickUnion uf = new WeightedQuickUnion(n);
        for(int i = 1; i < whitelist.length; i+=2) {
            int p = whitelist[i];
            int q = whitelist[i + 1];
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.printf("Elapsed Time: %5.1f\n", timer.elapsedTime());
    }
}
