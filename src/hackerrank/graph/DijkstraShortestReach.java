package hackerrank.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstraShortestReach {
    public static void main(String[] args) {
//        shortestReach(4, List.of(List.of(1, 2, 24), List.of(1, 4, 20), List.of(3, 1, 3), List.of(4, 3, 12)), 1);
        shortestReach(5, List.of(List.of(1, 2, 10), List.of(1, 3, 6), List.of(2, 4, 8)), 2);
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new LinkedList<>());

        for (List<Integer> curr : edges) {
            adj.get(curr.get(0)).add(new Edge(curr.get(0), curr.get(1), curr.get(2)));
            adj.get(curr.get(1)).add(new Edge(curr.get(1), curr.get(0), curr.get(2)));
        }

        for (int v = 0; v <= n; v++) {
            distTo[v] = -1;
        }
        distTo[s] = 0;

//        IndexMinPQ<Integer> pq = new IndexMinPQ<>(n + 1);
//        pq.insert(s, distTo[s]);
        PriorityQueue<Entry> pq = new PriorityQueue<>(n + 1);
        pq.add(new Entry(s, distTo[s]));
        while (!pq.isEmpty()) {
//            int v = pq.delMin();
            int v = pq.poll().key;
            for (Edge e : adj.get(v))
                relax(e, distTo, edgeTo, pq);
        }
        List<Integer> result = Arrays.stream(Arrays.copyOfRange(distTo, 1, distTo.length)).boxed().collect(Collectors.toList());
        result.remove(s - 1);

        return result;
    }

    private static void relax(Edge e, int[] distTo, Edge[] edgeTo, PriorityQueue<Entry> pq) {
        int v = e.from, w = e.to;
        if (distTo[w] == -1 || distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.remove(w);

            }
            pq.add(new Entry(w, distTo[w]));
//            if (pq.contains(w))
//                pq.decreaseKey(w, distTo[w]);
//            else
//                pq.insert(w, distTo[w]);
        }
    }

    private static class Entry implements Comparable<Entry> {
        private Integer key;
        private Integer distTo;

        public Entry(int key, int distTo) {
            this.key = key;
            this.distTo = distTo;
        }

        public int compareTo(Entry e) {
            return this.distTo.compareTo(e.distTo);
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
}
