package hackerrank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prims {

    public static void main(String[] args) {
//        prims(3, List.of(List.of(1, 2, 2), List.of(2, 3, 2), List.of(1, 3, 3)), 1);
        prims(5, List.of(List.of(1, 2, 3), List.of(1, 3, 4), List.of(4, 2, 6), List.of(5, 2, 2), List.of(2, 3, 5)), 1);
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
        int weight = 0;
        boolean[] marked = new boolean[n + 1];
        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Integer> mst = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            adj.put(i, new LinkedList<>());

        for (List<Integer> list : edges) {
            adj.get(list.get(0)).add(new Edge(list.get(0), list.get(1), list.get(2)));
            adj.get(list.get(1)).add(new Edge(list.get(1), list.get(0), list.get(2)));
        }

        scan(start, marked, pq, adj);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.from, w = e.to;
            if (!marked[v] || !marked[w]) {
                mst.add(e.from);
                weight += e.weight;
                if (!marked[v])
                    scan(v, marked, pq, adj);
                if (!marked[w])
                    scan(w, marked, pq, adj);
            }
        }
        return weight;
    }

    private static void scan(int v, boolean[] marked, PriorityQueue<Edge> pq, Map<Integer, LinkedList<Edge>> adj) {
        marked[v] = true;
        for (Edge currEdge : adj.get(v))
            if (!marked[currEdge.to])
                pq.add(currEdge);
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
