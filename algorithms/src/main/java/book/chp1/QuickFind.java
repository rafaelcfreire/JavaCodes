package book.chp1;

import book.common.In;
import book.common.StdOut;
import book.common.Stopwatch;

public final class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int N) {
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID= find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
        count--;
    }

    int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] whitelist = In.readInts(args[0]);
        int n = whitelist[0];
        QuickFind quickFind = new QuickFind(n);
        for(int i = 1; i < whitelist.length; i+=2) {
            int p = whitelist[i];
            int q = whitelist[i + 1];
            if (quickFind.find(p) == quickFind.find(q))
                continue;
            quickFind.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.printf("Elapsed Time: %5.1f\n", timer.elapsedTime());
    }
//    public static void main(String[] args) {
//        int[] whitelist = In.readInts(args[0]);
//        int n = StdIn.readInt();
//        QuickFind uf = new QuickFind(n);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.find(p) == uf.find(q)) continue;
//            uf.union(p, q);
//            StdOut.println(p + " " + q);
//        }
//        StdOut.println(uf.count() + " components");
//    }
}
