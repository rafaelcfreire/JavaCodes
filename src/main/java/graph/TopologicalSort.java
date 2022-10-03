package graph;

import java.util.ArrayList;
import java.util.List;

public final class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of());
        adj.add(List.of(0, 2, 3));
        adj.add(List.of(0, 3));
        adj.add(List.of());

        int[] result = topoSort(4, adj);
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, List<List<Integer>> adj)
    {
        boolean[] marked = new boolean[V];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++)
            if (!marked[i])
                dfs(i, adj, marked, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int v, List<List<Integer>> adj, boolean[] marked, List<Integer> result) {
        marked[v] = true;
        for (int w : adj.get(v)) {
            if (!marked[w])
                dfs(w, adj, marked, result);
        }
        result.add(v);
    }
}
