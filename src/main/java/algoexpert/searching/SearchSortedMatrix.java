package algoexpert.searching;

public final class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
//                {1, 4, 7, 12, 15, 1000},
//                {2, 5, 19, 31, 32, 1001},
//                {3, 8, 24, 33, 35, 1002},
//                {40, 41, 42, 44, 45, 1003},
//                {99, 100, 103, 106, 128, 1004}
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };

        int[] result = searchInSortedMatrix(matrix, 44);
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target)
                column -= 1;
            else if (matrix[row][column] < target)
                row += 1;
            else if (matrix[row][column] == target)
                return new int[]{row, column};
        }
        return new int[]{-1, -1};
    }
}
