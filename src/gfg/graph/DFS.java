package gfg.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                doDFS(i, adj, result, visited);
        }

        return result;
    }

    private static void doDFS(int i, ArrayList<ArrayList<Integer>> adj, List<Integer> result, boolean[] visited) {
        result.add(i);
        visited[i] = true;

        for (int v : adj.get(i))
            if (!visited[v])
                doDFS(v, adj, result, visited);
    }

    public static void main(String[] args) {
        ArrayList adj = new ArrayList();
        ArrayList zero = new ArrayList<>();
        zero.add(1);

        ArrayList one = new ArrayList<>();
        one.add(2);

        ArrayList two = new ArrayList<>();
        two.add(3);

        ArrayList three = new ArrayList<>();
        three.add(4);

        ArrayList four = new ArrayList<>();
        four.add(5);

        adj.add(zero);
        adj.add(one);
        adj.add(two);
        adj.add(three);
        adj.add(four);

        dfsOfGraph(5, adj);
    }
}
