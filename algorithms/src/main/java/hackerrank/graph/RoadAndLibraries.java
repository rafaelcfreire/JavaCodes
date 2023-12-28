package hackerrank.graph;

import java.util.*;

// https://www.hackerrank.com/challenges/torque-and-development/problem?isFullScreen=false
final class RoadAndLibraries {
    public static void main(String[] args) {
//        System.out.println(roadsAndLibraries(3, 2, 1, List.of(List.of(1, 2), List.of(3, 1), List.of(2, 3))));
//        System.out.println(roadsAndLibraries(6, 2, 5, List.of(List.of(1, 3), List.of(3, 4), List.of(2, 4), List.of(1, 2), List.of(2, 3), List.of(5, 6))));
//        System.out.println(roadsAndLibraries(7, 3, 2, List.of(List.of(1, 7), List.of(1, 3), List.of(1, 2), List.of(2, 3), List.of(5, 6), List.of(6, 8))));
        System.out.println(roadsAndLibraries(5, 6, 1, List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4))));

    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_lib <= c_road)
            return (long) n * c_lib;

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (List<Integer> curr : cities) {
            adjList.computeIfAbsent(curr.get(0), k -> new ArrayList<>()).add(curr.get(1));
            adjList.computeIfAbsent(curr.get(1), k -> new ArrayList<>()).add(curr.get(0));
        }

        boolean[] marked = new boolean[n + 1];
        long totalCost = 0;
        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                totalCost += c_lib;
                dfs(i, marked, adjList);
            } else {
                totalCost += c_road;
            }
        }
        return totalCost;
    }

    private static void dfs(int i, boolean[] marked, Map<Integer, List<Integer>> adjList) {
        marked[i] = true;
        for (int v : adjList.get(i)) {
            if (!marked[v]) {
                dfs(v, marked, adjList);
            }
        }
    }

}
