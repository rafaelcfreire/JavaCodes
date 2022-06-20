package hackerrank.graph;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DijkstraShortestReach {
    public static void main(String[] args) {
        shortestReach(4, List.of(List.of(1, 2, 24), List.of(1, 4, 20), List.of(3, 1, 3), List.of(4, 3, 12)), 1);
    }

    public static int[] shortestReach(int n, List<List<Integer>> edges, int s) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new LinkedList<>());

        for (List<Integer> curr :edges) {
            adj.get(curr.get(0)).add(new Edge(curr.get(0), curr.get(1), curr.get(2)));
            adj.get(curr.get(1)).add(new Edge(curr.get(1), curr.get(0), curr.get(2)));
        }

        for (int v = 0; v <= n; v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;

        IndexMinPQ<Integer> pq = new IndexMinPQ<>(n + 1);
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : adj.get(v))
                relax(e, distTo, edgeTo, pq);
        }

        return distTo;
    }

    private static void relax(Edge e, int[] distTo, Edge[] edgeTo, IndexMinPQ<Integer> pq) {
        int v = e.from, w = e.to;
        if (distTo[w] > distTo[v] + e.weight) {
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
}
