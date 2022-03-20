package leetcode.depthFirst;

// https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (!visited[i][j] && grid[i][j] == '1') {
                    exploreIsland(i, j, grid, visited);
                    islands++;
                }
        return islands;
    }

    private static void exploreIsland(int i, int j, char[][] grid, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1'&& !visited[i][j]) {
            visited[i][j] = true;
            exploreIsland(i - 1, j, grid, visited);
            exploreIsland(i + 1, j, grid, visited);
            exploreIsland(i, j - 1, grid, visited);
            exploreIsland(i, j + 1, grid, visited);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        };
        int result = numIslands(grid);
    }
}
