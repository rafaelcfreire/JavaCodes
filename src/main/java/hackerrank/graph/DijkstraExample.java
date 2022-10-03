package hackerrank.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://www.hackerrank.com/topics/shortest-paths-in-graphs
public final class DijkstraExample {

    public static void main(String[] args) {
        shortestReach(8, List.of(List.of(1, 2, 20), List.of(1, 4, 80), List.of(1, 7, 90), List.of(2, 6, 10), List.of(6, 4, 40), List.of(6, 3, 10),
            List.of(3, 6, 50), List.of(3, 8, 20), List.of(3, 4, 10), List.of(4, 3, 10), List.of(4, 7, 20), List.of(7, 1, 20), List.of(5, 7, 30), List.of(5, 2, 50)), 1);
    }

    public static int[] shortestReach(int n, List<List<Integer>> edges, int s) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            distTo[i] = Integer.MAX_VALUE;
            adj.put(i, new LinkedList<>());
        }
        distTo[s] = 0;

        for (List<Integer> current : edges)
            adj.get(current.get(0)).add(new Edge(current.get(0), current.get(1), current.get(2)));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(s);

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            for (Edge e : adj.get(curr))
                relax(e, distTo, edgeTo, pq);
        }
        return distTo;
    }

    private static void relax(Edge edge, int[] distTo, Edge[] edgeTo, PriorityQueue pq) {
        int v = edge.from, w = edge.to;
        if (edge.weight + distTo[v] < distTo[w]) {
            distTo[w] = edge.weight + distTo[v];
            edgeTo[w] = edge;
            pq.add(w);
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private Integer weight;

        public Edge(int from, int to, Integer weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
