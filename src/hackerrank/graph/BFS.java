package hackerrank.graph;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BFS {

    public static void main(String[] args) {
//        List<Integer> result = bfs(5, 3, List.of(List.of(1, 2), List.of(1, 3), List.of(3, 4)), 5);
        List<Integer> result = bfs(10, 6, List.of(List.of(3, 1), List.of(10, 1), List.of(10, 1), List.of(3, 1), List.of(1, 8), List.of(5, 2)), 3);

    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new HashSet<>());

        for (List<Integer> curr : edges) {
            adj.get(curr.get(0)).add(curr.get(1));
            adj.get(curr.get(1)).add(curr.get(0));
        }

        for (int i = 1; i <= n; i++)
            if (i != s) {
                int size = result.size();
                boolean[] marked = new boolean[n + 1];
                visit(s, i, 0, adj, result, marked);
                if (result.size() == size)
                    result.add(-1);
            }
        return result;
    }

    private static void visit(int origin, int destiny, int weight, Map<Integer, HashSet<Integer>> adj, List<Integer> result, boolean[] marked) {
        marked[origin] = true;
        if (origin == destiny) {
            result.add(weight);
            return;
        }

        Set<Integer> neighbors = adj.get(origin);
        if (neighbors.isEmpty())
            return;

        for (int neighbor : neighbors) {
            if (!marked[neighbor])
                visit(neighbor, destiny, weight + 6, adj, result, marked);
        }
    }

}