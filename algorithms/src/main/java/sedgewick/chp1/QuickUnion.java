package sedgewick.chp1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class QuickUnion {
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
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }
        id[i] = j;
        count--;
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("algorithms/src/main/java/book/chp1/largeUF.txt"))) {
            Stopwatch timer = new Stopwatch();

            int n = Integer.parseInt(bufferedReader.readLine());
            QuickUnion quickUnion = new QuickUnion(n);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                int p = Integer.parseInt(temp[0]);
                int q = Integer.parseInt(temp[1]);

                if (quickUnion.find(p) == quickUnion.find(q))
                    continue;
                quickUnion.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdOut.printf("Total amount of components: %d\n", quickUnion.count());
            StdOut.printf("Elapsed Time: %5.1f\n", timer.elapsedTime());
        }
    }
}
