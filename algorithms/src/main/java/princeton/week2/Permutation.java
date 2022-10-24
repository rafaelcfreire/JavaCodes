package princeton.week2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public final class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randqueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty())
            randqueue.enqueue(StdIn.readString());

        int k = Integer.parseInt(args[0]);
        if (k < 0 || k > randqueue.size())
            throw new IllegalArgumentException();

        for (String s : randqueue) {
            if (k == 0) break;
            StdOut.println(s);
            k--;
        }
    }
}
