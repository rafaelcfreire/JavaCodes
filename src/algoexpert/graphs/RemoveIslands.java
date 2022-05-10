package algoexpert.graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveIslands {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
        };

        int[][] result = removeIslands(matrix);
    }

    public static int[][] removeIslands(int[][] matrix) {
        boolean [][] aux = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++) {
                boolean rowIsBorder = row == 0 || row == matrix.length - 1;
                boolean columnIsBorder = column == 0 || column == matrix[row].length - 1;
                boolean isBorder = rowIsBorder || columnIsBorder;

                if (isBorder && matrix[row][column] == 1)
                    findBorderElements(matrix, row, column, aux);
            }

        for (int i = 1; i < matrix.length - 1; i++)
            for (int j = 1; j < matrix[i].length - 1; j++)
                if (matrix[i][j] == 1 && !aux[i][j])
                    matrix[i][j] = 0;
        return matrix;
    }

    private static void findBorderElements(int[][] matrix, int row, int column, boolean[][] aux) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, column});

        while (!stack.isEmpty()) {
            int[] currentPosition = stack.pop();
            int currRow = currentPosition[0];
            int currColumn = currentPosition[1];

            if (!aux[currRow][currColumn]) {
                aux[currRow][currColumn] = true;

                int[][] neighbors = getNeighbors(matrix, currRow, currColumn);
                for (int[] neighbor : neighbors) {
                    if (matrix[neighbor[0]][neighbor[1]] == 1)
                        stack.push(neighbor);
                }
            }
        }
    }

    private static int[][] getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> temp = new ArrayList<>();

        if (row - 1 > 0)
            temp.add(new int[]{row - 1, col});
        if (row + 1 < matrix.length)
            temp.add(new int[]{row + 1, col});
        if (col - 1 >= 0)
            temp.add(new int[]{row, col - 1});
        if (col + 1 < matrix[row].length)
            temp.add(new int[]{row, col + 1});

        int[][] neighbors = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++)
            neighbors[i] = temp.get(i);
        return neighbors;
    }

}
