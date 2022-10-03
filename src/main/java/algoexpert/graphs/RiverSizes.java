package algoexpert.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public final class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                if (!visited[i][j])
                    traverseNodeBFS(i, j, matrix, visited, sizes);
        }
        return sizes;
    }

    private static void traverseNodeDFS(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentSize = 0;
        Stack<Integer[]> nodesToVisit = new Stack<>();
        nodesToVisit.push(new Integer[]{i, j});

        while (!nodesToVisit.isEmpty()) {
            Integer[] currentNode = nodesToVisit.pop();
            int line = currentNode[0];
            int column = currentNode[1];

            if (!visited[line][column]) {
                visited[line][column] = true;

                if (matrix[line][column] != 0) {
                    currentSize++;
                    List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(line, column, matrix, visited);

                    for (Integer[] neighbor : unvisitedNeighbors)
                        nodesToVisit.push(neighbor);
                }
            }
        }
        if (currentSize > 0)
            sizes.add(currentSize);
    }

    private static void traverseNodeBFS(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentSize = 0;
        Queue<Integer[]> nodesToVisit = new LinkedList<>();
        nodesToVisit.offer(new Integer[]{i, j});

        while (!nodesToVisit.isEmpty()) {
            Integer[] currentNode = nodesToVisit.poll();
            int line = currentNode[0];
            int column = currentNode[1];

            if (!visited[line][column]) {
                visited[line][column] = true;

                if (matrix[line][column] != 0) {
                    currentSize++;
                    List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(line, column, matrix, visited);

                    for (Integer[] neighbor : unvisitedNeighbors)
                        nodesToVisit.offer(neighbor);
                }
            }
        }
        if (currentSize > 0)
            sizes.add(currentSize);
    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();

        if (i > 0 && !visited[i - 1][j])
            unvisitedNeighbors.add(new Integer[]{i - 1, j});
        if (i < matrix.length - 1 && !visited[i + 1][j])
            unvisitedNeighbors.add(new Integer[]{i + 1, j});
        if (j > 0 && !visited[i][j - 1])
            unvisitedNeighbors.add(new Integer[]{i, j - 1});
        if (j < matrix[i].length - 1 && !visited[i][j + 1])
            unvisitedNeighbors.add(new Integer[]{i, j + 1});

        return unvisitedNeighbors;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}
        };
        List<Integer> result = riverSizes(matrix);
    }
}
