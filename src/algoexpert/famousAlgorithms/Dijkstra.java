package algoexpert.famousAlgorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        dijkstrasAlgorithm(0, new int[][][]
        {
            {{1, 7}},
            {{2, 6}, {3, 20}, {4, 3}},
            {{3, 14}},
            {{4, 2}},
            {},
            {}
        });
    }

    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int nEdges = edges.length;
        int[] distTo = new int[nEdges];
        Edge edgeTo[] = new Edge[nEdges];

        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        for (int i = 0; i < nEdges; i++) {
            adj.put(i, new LinkedList<>());
            distTo[i] = -1;
        }
        distTo[start] = 0;

        for (int i = 0; i < nEdges; i++)
            for (int j = 0; j < edges[i].length; j++)
                adj.get(i).add(new Edge(i, edges[i][j][0], edges[i][j][1]));

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        pq.add(new Entry(start, distTo[start]));

        while (!pq.isEmpty()) {
            int v = pq.poll().key;
            for (Edge e : adj.get(v))
                relax(e, distTo, edgeTo, pq);
        }
        return distTo;
    }

    private static void relax(Edge e, int[] distTo, Edge[] edgeTo, PriorityQueue<Entry> pq) {
        int v = e.from, w = e.to;
        if (distTo[w] == -1 || distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edgeTo[w] = e;
            pq.add(new Entry(w, distTo[w]));
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
            return this.weight.compareTo(e.weight);
        }
    }
}
