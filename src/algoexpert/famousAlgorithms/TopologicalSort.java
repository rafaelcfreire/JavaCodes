package algoexpert.famousAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static void main(String[] args) {
        TopologicalSort tp = new TopologicalSort();
//CASE 1
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        deps.add(new Integer[]{4, 3});

        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4), deps);

//CASE 2
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{3, 1});
//        deps.add(new Integer[]{8, 1});
//        deps.add(new Integer[]{8, 7});
//        deps.add(new Integer[]{5, 7});
//        deps.add(new Integer[]{5, 2});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{1, 6});
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{7, 6});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 3
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{3, 1});
//        deps.add(new Integer[]{8, 1});
//        deps.add(new Integer[]{8, 7});
//        deps.add(new Integer[]{5, 7});
//        deps.add(new Integer[]{5, 2});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{6, 7});
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{7, 6});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 4
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{3, 1});
//        deps.add(new Integer[]{8, 1});
//        deps.add(new Integer[]{8, 7});
//        deps.add(new Integer[]{5, 7});
//        deps.add(new Integer[]{5, 2});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{1, 6});
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{7, 6});
//        deps.add(new Integer[]{4, 6});
//        deps.add(new Integer[]{6, 2});
//        deps.add(new Integer[]{2, 3});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 5
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{2, 3});
//        deps.add(new Integer[]{3, 4});
//        deps.add(new Integer[]{4, 5});
//        deps.add(new Integer[]{5, 6});
//        deps.add(new Integer[]{6, 7});
//        deps.add(new Integer[]{7, 8});
//        deps.add(new Integer[]{8, 1});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 6
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{2, 3});
//        deps.add(new Integer[]{3, 4});
//        deps.add(new Integer[]{4, 5});
//        deps.add(new Integer[]{5, 6});
//        deps.add(new Integer[]{7, 6});
//        deps.add(new Integer[]{7, 8});
//        deps.add(new Integer[]{8, 1});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), deps);

//CASE 7
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{3, 5});
//        deps.add(new Integer[]{4, 6});
//        deps.add(new Integer[]{3, 6});
//        deps.add(new Integer[]{1, 7});
//        deps.add(new Integer[]{7, 8});
//        deps.add(new Integer[]{2, 8});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 8
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{1, 3});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{1, 5});
//        deps.add(new Integer[]{1, 6});
//        deps.add(new Integer[]{1, 7});
//        deps.add(new Integer[]{2, 8});
//        deps.add(new Integer[]{3, 8});
//        deps.add(new Integer[]{4, 8});
//        deps.add(new Integer[]{5, 8});
//        deps.add(new Integer[]{6, 8});
//        deps.add(new Integer[]{7, 8});
//
//        List<Integer> result = tp.topologicalSort(List.of(1, 2, 3, 4, 5, 6, 7, 8), deps);

//CASE 9
//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{1, 3});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{1, 5});
//        deps.add(new Integer[]{1, 6});
//        deps.add(new Integer[]{1, 7});
//        deps.add(new Integer[]{2, 8});
//        deps.add(new Integer[]{3, 8});
//        deps.add(new Integer[]{4, 8});
//        deps.add(new Integer[]{5, 8});
//        deps.add(new Integer[]{6, 8});
//        deps.add(new Integer[]{7, 8});
//        deps.add(new Integer[]{2, 3});
//        deps.add(new Integer[]{2, 4});
//        deps.add(new Integer[]{5, 4});
//        deps.add(new Integer[]{7, 6});
//        deps.add(new Integer[]{6, 2});
//        deps.add(new Integer[]{6, 3});
//        deps.add(new Integer[]{6, 5});
//        deps.add(new Integer[]{5, 9});
//        deps.add(new Integer[]{9, 8});
//        deps.add(new Integer[]{8, 0});
//        deps.add(new Integer[]{4, 0});
//        deps.add(new Integer[]{5, 0});
//        deps.add(new Integer[]{9, 0});
//        deps.add(new Integer[]{2, 0});
//        deps.add(new Integer[]{3, 9});
//        deps.add(new Integer[]{3, 10});
//        deps.add(new Integer[]{10, 11});
//        deps.add(new Integer[]{11, 12});
//        deps.add(new Integer[]{2, 12});
//        List<Integer> result = tp.topologicalSort(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), deps);


//        List<Integer[]> deps = new ArrayList<>();
//        deps.add(new Integer[]{1, 2});
//        deps.add(new Integer[]{1, 3});
//        deps.add(new Integer[]{1, 4});
//        deps.add(new Integer[]{1, 5});
//        deps.add(new Integer[]{1, 6});
//        deps.add(new Integer[]{1, 7});
//        deps.add(new Integer[]{2, 8});
//        deps.add(new Integer[]{3, 8});
//        deps.add(new Integer[]{4, 8});
//        deps.add(new Integer[]{5, 8});
//        deps.add(new Integer[]{6, 8});
//        deps.add(new Integer[]{7, 8});
//        deps.add(new Integer[]{2, 3});
//        deps.add(new Integer[]{2, 4});
//        deps.add(new Integer[]{5, 4});
//        deps.add(new Integer[]{7, 6});
//        deps.add(new Integer[]{6, 2});
//        deps.add(new Integer[]{6, 3});
//        deps.add(new Integer[]{6, 5});
//        deps.add(new Integer[]{5, 9});
//        deps.add(new Integer[]{9, 8});
//        deps.add(new Integer[]{8, 0});
//        deps.add(new Integer[]{4, 0});
//        deps.add(new Integer[]{5, 0});
//        deps.add(new Integer[]{9, 0});
//        deps.add(new Integer[]{2, 0});
//        deps.add(new Integer[]{3, 9});
//        deps.add(new Integer[]{3, 10});
//        deps.add(new Integer[]{10, 11});
//        deps.add(new Integer[]{11, 12});
//        deps.add(new Integer[]{12, 2});
//
//        List<Integer> result = tp.topologicalSort(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), deps);

    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        boolean[] marked = new boolean[jobs.size() + 1];
        boolean[] onStack = new boolean[jobs.size() + 1];
        List<Integer> results = new ArrayList<>();

        Map<Integer, LinkedList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < jobs.size(); i++)
            adj.put(jobs.get(i), new LinkedList<>());

        for (Integer[] curr : deps)
            adj.get(curr[1]).add(curr[0]);

        boolean hasCycle = false;
        for (int v : jobs)
            if (!marked[v]) {
                hasCycle = dfs(v, marked, onStack, adj, results);
                if (hasCycle) break;
            }
        return hasCycle ? List.of() : results;
    }

    private static boolean dfs(int v, boolean[] marked, boolean[] onStack, Map<Integer, LinkedList<Integer>> adj, List<Integer> results) {
        marked[v] = true;
        onStack[v] = true;

        for (int w : adj.get(v)) {
            if (onStack[w])
                return true;
            if (!marked[w]) {
                boolean hasCycle = dfs(w, marked, onStack, adj, results);
                if (hasCycle)
                    return true;
            }
        }
        onStack[v] = false;
        results.add(v);
        return false;
    }
}
