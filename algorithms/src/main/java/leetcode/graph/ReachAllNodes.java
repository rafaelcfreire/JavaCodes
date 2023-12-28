package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
final class ReachAllNodes {
    public static void main(String[] args) {
//        findSmallestSetOfVertices(6, List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2)));
//        findSmallestSetOfVertices(5, List.of(List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4)));
//        findSmallestSetOfVertices(3, List.of(List.of(1,2), List.of(1,0), List.of(0,2)));
        findSmallestSetOfVertices(4, List.of(List.of(2, 0), List.of(0, 3), List.of(3, 1)));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] marked = new boolean[n];
        boolean[] onStack = new boolean[n];
        boolean[] hasPointer = new boolean[n];
        List<Integer> results = new ArrayList<>();

        Map<Integer, LinkedList<Integer>> adj = new LinkedHashMap<>();
        for (int i = 0; i < n; i++)
            adj.put(i, new LinkedList<>());

        for (List<Integer> edge : edges) {
            int i = edge.get(0), v = edge.get(1);
            adj.get(i).push(v);
            hasPointer[v] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i] && !hasPointer[i])
                dfs(adj, results, marked, onStack, i, 0);
        }
        return results;
    }

    private static void dfs(Map<Integer, LinkedList<Integer>> adj, List<Integer> results, boolean[] marked, boolean[] onStack, int i, int itemsOnStack) {
        marked[i] = true;
        onStack[i] = true;
        itemsOnStack++;

        for (int v : adj.get(i)) {
            if (onStack[v])
                return;
            if (!marked[v])
                dfs(adj, results, marked, onStack, v, itemsOnStack);
        }
        onStack[i] = false;
        itemsOnStack--;
        if (itemsOnStack == 0)
            results.add(i);
    }
}