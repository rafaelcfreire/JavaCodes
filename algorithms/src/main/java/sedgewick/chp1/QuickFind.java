package sedgewick.chp1;

import sedgewick.common.In;
import sedgewick.common.StdOut;
import sedgewick.common.Stopwatch;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("algorithms/src/main/java/book/chp1/largeUF.txt"))) {
            Stopwatch timer = new Stopwatch();

            int n = Integer.parseInt(bufferedReader.readLine());
            QuickFind quickFind = new QuickFind(n);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                int p = Integer.parseInt(temp[0]);
                int q = Integer.parseInt(temp[1]);

                if (quickFind.find(p) == quickFind.find(q))
                    continue;
                quickFind.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdOut.printf("Total amount of components: %d\n", quickFind.count());
            StdOut.printf("Elapsed Time: %5.1f\n", timer.elapsedTime());
        }
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
