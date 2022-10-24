package algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public final class SpiralTraverse {
    public static void main(String[] args) {
        int[][] array = new int[][]{
//                {1}
//            {1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}
//                {1, 2, 3}, {8, 9, 4}, {7, 6, 5}
//                {1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}
                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10}, {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}
        };
//        spiralTraverse(array);
        List<Integer> results = spiralTraverseRecursive(array);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> results = new ArrayList<>();
        int startingRow = 0, startingColumn = 0,
                endingRow = array.length - 1, endingColumn = array[startingRow].length - 1;

        while (startingRow <= endingRow && startingColumn <= endingColumn) {
            for (int i = startingColumn; i <= endingColumn; i++)
                results.add(array[startingRow][i]);
            for (int i = startingRow + 1; i <= endingRow; i++)
                results.add(array[i][endingColumn]);
            for (int i = endingColumn - 1; i >= startingColumn; i--) {
                if (endingRow != startingRow)
                    results.add(array[endingRow][i]);
            }
            for (int i = endingRow - 1; i > startingRow; i--) {
                if (endingColumn != startingColumn) {
                    results.add(array[i][startingColumn]);
                }
            }
            startingRow +=1;
            startingColumn += 1;
            endingRow -= 1;
            endingColumn -= 1;
        }
        return results;
    }

    public static List<Integer> spiralTraverseRecursive(int[][] array) {
        List<Integer> results = new ArrayList<>();

        spiralTraverseRecursive(array, 0, 0,
                array.length - 1, array[0].length - 1, results);

        return results;
    }

    private static void spiralTraverseRecursive(int[][] array, int startingRow,
                                             int startingColumn, int endingRow, int endingColumn, List<Integer> results) {

        if (endingRow < startingRow || endingColumn < startingColumn)
            return ;

        for (int i = startingColumn; i <= endingColumn; i++)
            results.add(array[startingRow][i]);
        for (int i = startingRow + 1; i <= endingRow; i++)
            results.add(array[i][endingColumn]);
        for (int i = endingColumn - 1; i >= startingColumn; i--) {
            if (endingRow != startingRow)
                results.add(array[endingRow][i]);
        }
        for (int i = endingRow - 1; i > startingRow; i--) {
            if (endingColumn != startingColumn) {
                results.add(array[i][startingColumn]);
            }
        }
        spiralTraverseRecursive(array, startingRow + 1,
                startingColumn + 1, endingRow - 1, endingColumn - 1, results);
    }
}
