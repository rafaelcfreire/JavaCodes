package algo.book.chp4;

import hackerrank.graph.DijkstraExample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BellmanFord {
    public static void main(String[] args) {

    }

    public static int[] shortestReach(int n, List<List<Integer>> edges, int s) {
        int[] distTo = new int[n + 1];
        Edge[] edgeTo = new Edge[n + 1];
        boolean[] onQueue = new boolean[n + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            distTo[i] = Integer.MAX_VALUE;
            adj.put(i, new LinkedList<>());
        }
        distTo[s] = 0;
        for (List<Integer> current : edges)
            adj.get(current.get(0)).add(new Edge(current.get(0), current.get(1), current.get(2)));

        queue.add(s);
        while (!queue.isEmpty()) {

        }
        return distTo;
    }

    private static void relax(Edge edge, int[] distTo, Edge[] edgeTo, LinkedList<Integer> queue, boolean[] onQueue, Map<Integer, LinkedList<Edge>> adj) {
        for (Edge curr : adj.get(edge.from)) {
            int w = curr.to;
            if (distTo[w] > distTo[curr.from] + curr.weight) {
                distTo[w] = distTo[curr.from] + curr.weight;
                edgeTo[w] = curr;
                if (!onQueue[w]) {
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
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
