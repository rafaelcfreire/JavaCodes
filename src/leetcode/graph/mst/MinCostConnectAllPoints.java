package leetcode.graph.mst;

import hackerrank.graph.Prims;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostConnectAllPoints {
    public static void main(String[] args) {
        minCostConnectPoints(new int[][] {{0,0}, {2, 2}, {3, 10}, {5, 2}, {7,0}});
    }

    public static int minCostConnectPoints(int[][] points) {
        int weight = 0;
        int nodes = points.length;
        boolean[] marked = new boolean[nodes];
        Map<Integer, LinkedList<Edge>> adj = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < nodes; i++)
            adj.put(i, new LinkedList<>());

        for (int i = 0; i < nodes; i++)
            for (int j = i + 1; j < nodes; j++)
                adj.get(i).add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));

        return weight;
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
