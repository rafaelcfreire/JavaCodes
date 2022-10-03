package leetcode.graph;

import java.util.*;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public final class AllPathsFromSource {
    public static void main(String[] args) {
//        int[][] adjacencyMatrix = new int[][] {
//                {1, 2},
//                {3},
//                {3},
//                {}
//        };
        int[][] adjacencyMatrix = new int[][] {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };
        allPathsSourceTarget(adjacencyMatrix);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, result);
        return result;
    }

    private static void dfs(int currentValue, int[][] graph, List<Integer> path, List<List<Integer>> results) {
        if (currentValue == graph.length - 1) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int edge : graph[currentValue]) {
            path.add(edge);
            dfs(edge, graph, path, results);
            path.remove(Integer.valueOf(edge));
        }
    }
}
