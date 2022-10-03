package hackerrank.graph;


import java.util.*;
import java.util.stream.Collectors;

public final class DijkstraShortestReach {
    public static void main(String[] args) {
//        shortestReach(4, List.of(List.of(1, 2, 24), List.of(1, 4, 20), List.of(3, 1, 3), List.of(4, 3, 12)), 1);
        shortestReach(5, List.of(List.of(1, 2, 10), List.of(1, 3, 6), List.of(2, 4, 8)), 2);
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            adj.put(i, new LinkedList<>());
            distTo[i] = -1;
        }
        distTo[s] = 0;

        for (List<Integer> curr : edges) {
            adj.get(curr.get(0)).add(new Edge(curr.get(0), curr.get(1), curr.get(2)));
            adj.get(curr.get(1)).add(new Edge(curr.get(1), curr.get(0), curr.get(2)));
        }

        MinPQ<Integer> pq = new MinPQ<>(n + 1);
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : adj.get(v))
                relax(e, distTo, edgeTo, pq);
        }
        List<Integer> result = Arrays.stream(Arrays.copyOfRange(distTo, 1, distTo.length)).boxed().collect(Collectors.toList());
        result.remove(s - 1);

        return result;
    }

    private static void relax(Edge e, int[] distTo, Edge[] edgeTo, MinPQ<Integer> pq) {
        int v = e.from, w = e.to;
        if (distTo[w] == -1 || distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            if (pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
    }

    private static class Edge implements Comparable<Edge> {
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

    private static class MinPQ<Key extends Comparable<Key>> {
        private int n;
        private int[] pq;        // binary heap using 1-based indexing
        private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
        private Key[] keys;      // keys[i] = priority of i

        public MinPQ(int maxN) {
            if (maxN < 0) throw new IllegalArgumentException();
            n = 0;
            keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
            pq   = new int[maxN + 1];
            qp   = new int[maxN + 1];                   // make this of length maxN??
            for (int i = 0; i <= maxN; i++)
                qp[i] = -1;
        }

        public boolean contains(int i) {
            return qp[i] != -1;
        }

        public void insert(int i, Key key) {
            if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
            n++;
            qp[i] = n;
            pq[n] = i;
            keys[i] = key;
            swim(n);
        }

        private void swim(int k) {
            while (k > 1 && greater(k/2, k)) {
                exch(k, k/2);
                k = k/2;
            }
        }

        private boolean greater(int i, int j) {
            return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }

        private void exch(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int delMin() {
            if (n == 0) throw new NoSuchElementException("Priority queue underflow");
            int min = pq[1];
            exch(1, n--);
            sink(1);
            assert min == pq[n+1];
            qp[min] = -1;        // delete
            keys[min] = null;    // to help with garbage collection
            pq[n+1] = -1;        // not needed
            return min;
        }

        private void sink(int k) {
            while (2*k <= n) {
                int j = 2*k;
                if (j < n && greater(j, j+1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public void decreaseKey(int i, Key key) {
            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
            if (keys[i].compareTo(key) == 0)
                throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
            if (keys[i].compareTo(key) < 0)
                throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the priority queue");
            keys[i] = key;
            swim(qp[i]);
        }
    }
}
