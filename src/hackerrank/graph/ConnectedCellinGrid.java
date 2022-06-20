package hackerrank.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedCellinGrid {

    public static void main(String[] args) {
        int result = maxRegion(new int[][] {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}});
//        int result = maxRegion(new int[][] {{0, 0, 1, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
    }

    public static int maxRegion(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxValue = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    int result = dfs(grid, i, j, visited);
                    if (result > maxValue)
                        maxValue = result;
                }
            }
        return maxValue;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int currentMax = 0;
        Stack<Integer[]> nodesToVisit = new Stack<>();
        nodesToVisit.push(new Integer[] {i, j});

        while (!nodesToVisit.isEmpty()) {
            Integer[] curr = nodesToVisit.pop();
            int line = curr[0], column = curr[1];

            if (!visited[line][column]) {
                visited[line][column] = true;

                if (grid[line][column] != 0) {
                    currentMax++;
                    List<Integer[]> unvisitedNeighbors = unvisitedNeighbors(line, column, grid, visited);

                    for (Integer[] item : unvisitedNeighbors)
                        nodesToVisit.add(item);
                }
            }
        }
        return currentMax;
    }

    private static List<Integer[]> unvisitedNeighbors(int i, int j, int[][] grid, boolean[][] visited) {
        List<Integer[]> neighbors = new ArrayList<>();

        if (i > 0) {
            if (j > 0 && !visited[i - 1][j - 1])
                neighbors.add(new Integer[]{i - 1, j - 1});
            if (j < grid[i].length - 1 && !visited[i - 1][j + 1])
                neighbors.add(new Integer[]{i - 1, j + 1});
            if (!visited[i - 1][j])
                neighbors.add(new Integer[]{i - 1, j});
        }
        if (i < grid.length - 1) {
            if (j > 0 && !visited[i + 1][j - 1])
                neighbors.add(new Integer[]{i + 1, j - 1});
            if (j < grid[i].length - 1 && !visited[i + 1][j + 1])
                neighbors.add(new Integer[]{i + 1, j + 1});
            if(!visited[i + 1][j])
                neighbors.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1])
            neighbors.add(new Integer[]{i, j - 1});
        if (j < grid[i].length - 1 && !visited[i][j+1])
            neighbors.add(new Integer[]{i, j + 1});
        return neighbors;
    }
}
