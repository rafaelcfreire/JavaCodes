package hackerrank.graph;

// https://www.hackerrank.com/challenges/kruskalmstrsub/problem

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public final class Kruskal {

    public static void main(String[] args) {
        kruskals(4, List.of(1, 1, 4, 2, 3, 3), List.of(2, 3, 1, 4, 2, 4), List.of(5, 3, 6, 7, 4, 5));
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); i++)
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));

        UF uf = new UF(gNodes + 1);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);

        List<Edge> mst = new ArrayList<>();
        int sum = 0;
        while (mst.size() < gNodes - 1) {
            Edge lowest = pq.poll();
            if (uf.find(lowest.from) != uf.find(lowest.to)) {
                uf.union(lowest.from, lowest.to);
                mst.add(lowest);
                sum += lowest.weight;
            }
        }
        return sum;
    }

    private static class Edge implements Comparable<Edge>{
        Integer from;
        Integer to;
        Integer weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            int w = this.weight.compareTo(e.weight);
            return w == 0 ? this.from.compareTo(e.from) : w;
        }
    }

    private static class UF {
        private int[] parent;
        private int[] size;
        private int count;

        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
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
    }
}
