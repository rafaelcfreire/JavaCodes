package hackerrank.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem?isFullScreen=false
final class ConnectedCellsInAGrid {
    public static void main(String[] args) {
        int maxValue = connectedCell(List.of(List.of(1, 1, 0, 0), List.of(0, 1, 1, 0), List.of(0, 0, 1, 0), List.of(1, 0, 0, 0)));
        System.out.println(maxValue);
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        boolean[][] visited = new boolean[matrix.size()][matrix.get(0).size()];
        int maxValue = 0;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (!visited[i][j]) {
                    int result = dfs(matrix, i, j, visited);
                    if (result > maxValue)
                        maxValue = result;
                }
            }
        }
        return maxValue;
    }

    private static int dfs(List<List<Integer>> matrix, int i, int j, boolean[][] visited) {
        int currMax = 0;
        Stack<Integer[]> nodesToVisit = new Stack<>();
        nodesToVisit.push(new Integer[]{i, j});

        while (!nodesToVisit.isEmpty()) {
            Integer[] curr = nodesToVisit.pop();
            int line = curr[0], column = curr[1];

            if (!visited[line][column]) {
                visited[line][column] = true;

                if (matrix.get(line).get(column) != 0) {
                    currMax++;
                    List<Integer[]> unvisitedNeighbors = unvisitedNeighbors(matrix, line, column, visited);

                    for (Integer[] item : unvisitedNeighbors)
                        nodesToVisit.push(item);
                }
            }
        }
        return currMax;
    }

    private static List<Integer[]> unvisitedNeighbors(List<List<Integer>> matrix, int i, int j, boolean[][] visited) {
        List<Integer[]> neighbors = new ArrayList<>();

        if (i > 0) {
            if (j > 0 && !visited[i - 1][j - 1])
                neighbors.add(new Integer[]{i - 1, j - 1});
            if (j < matrix.get(i).size() - 1 && !visited[i - 1][j + 1])
                neighbors.add(new Integer[]{i - 1, j + 1});
            if (!visited[i - 1][j])
                neighbors.add(new Integer[]{i - 1, j});
        }
        if (i < matrix.size() - 1) {
            if (j > 0 && !visited[i + 1][j - 1])
                neighbors.add(new Integer[]{i + 1, j - 1});
            if (j < matrix.get(i).size() - 1 && !visited[i + 1][j + 1])
                neighbors.add(new Integer[]{i + 1, j + 1});
            if(!visited[i + 1][j])
                neighbors.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1])
            neighbors.add(new Integer[]{i, j - 1});
        if (j < matrix.get(i).size() - 1 && !visited[i][j+1])
            neighbors.add(new Integer[]{i, j + 1});
        return neighbors;
    }
}
