package hackerrank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

// https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BFS {

    public static void main(String[] args) {
        List<Integer> result = bfs(5, 3, List.of(List.of(1, 2), List.of(1, 3), List.of(3, 4)), 1);
    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n - 1; i++)
//            result.add(-1);

        Map<Integer, LinkedList<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new LinkedList<>());

        for (List<Integer> curr : edges)
            adj.get(curr.get(0)).add(curr.get(1));

        for (int i = 1; i <= n; i++)
            result.add(visit(s, i, 0, adj));
        return result;
    }

    private static int visit(int origin, int destiny, int weight, Map<Integer, LinkedList<Integer>> adj) {
        if
    }

}

//        if (origin == destiny) {
//            result.add(weight);
//            return true;
//            }
//            LinkedList<Integer> neighbors = adj.get(origin);
//
//    for (int neighbor : neighbors) {
//    boolean found = visit(neighbor, destiny, weight + 6, adj, result);
//    if (found) break;
//    }
//    result.add(-1);
//    return false;
