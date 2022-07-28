package leetcode.graph.dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new LinkedList<>());
            distTo[i] = -1;
        }
        distTo[k] = 0;

        for (int[] curr : times)
            adj.get(curr[0]).add(new Edge(curr[0], curr[1], curr[2]));

        pq.add(new Edge(k, k, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            for (Edge edge : adj.get(curr.from))
                relax(edge, distTo, edgeTo, pq);
        }

        Arrays.sort(distTo);
        return distTo[0] == -1 ? distTo[0] : distTo[n];
    }

    private static void relax(Edge e, int[] distTo, Edge[] edgeTo, PriorityQueue<Edge> pq) {
        int v = e.from, w = e.to;
        if (distTo[w] == -1 || distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            pq.add(new Edge(w, 0, 0));
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
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
