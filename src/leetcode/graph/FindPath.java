package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindPath {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        validPath(6, edges, 0, 5);
//        int[][] edges = new int[][] {
//                {0, 7},
//                {0, 8},
//                {6, 1},
//                {2, 0},
//                {0, 4},
//                {5, 8},
//                {4, 7},
//                {1, 3},
//                {3, 5},
//                {6, 5}
//        };
//        validPath(10, edges, 7, 5);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<LinkedList<Integer>> adjacentMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjacentMatrix.add(new LinkedList<>());

        for (int[] edge : edges) {
            adjacentMatrix.get(edge[0]).add(edge[1]) ;
            adjacentMatrix.get(edge[1]).add(edge[0]);
        }
        return bfs(adjacentMatrix, source, destination);
    }

    private static boolean bfs(List<LinkedList<Integer>> adjacentMatrix, int source, int destination) {
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[adjacentMatrix.size()];
        visited[source] = true;

        for (int i = 0; i < adjacentMatrix.get(source).size(); i++)
            queue.add(adjacentMatrix.get(source).get(i));

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (int i = 0; i < adjacentMatrix.get(current).size(); i++) {
                if (!visited[adjacentMatrix.get(current).get(i)])
                    queue.add(adjacentMatrix.get(current).get(i));
            }
            if (current == destination)
                return true;
        }
        return false;
    }
}
