package clrs.chp4;

final class SquareMatrixMultiplier {
    public static void main(String[] args) {
        int[][] a = {{1,2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] b = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};

        //squareMatrixMultiply(new int[][]{{1,2}, {3, 4}}, new int[][]{{3, 4}, {1, 2}});
        squareMatrixMultiply(a, b);
    }
    private static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[a.length][a.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}