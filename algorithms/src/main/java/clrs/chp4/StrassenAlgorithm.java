package clrs.chp4;

final class StrassenAlgorithm {

    public static void main(String[] args) {
        int[][] a = {{1,2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] b = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};

        int[][] result = strassenMultiply(a, b);
        System.out.println(result);
    }

    //private static void split(int[][] parent, int[][] child, int )
    public static int[][] strassenMultiply(int[][] a, int[][] b) {
        int n = a.length;

        if (n == 1) {
            int[][] c = {{a[0][0] * b[0][0]}};
            return c;
        }

        //divide step
        int[][] a11 = new int[n/2][n/2];
        int[][] a12 = new int[n/2][n/2];
        int[][] a21 = new int[n/2][n/2];
        int[][] a22 = new int[n/2][n/2];

        int[][] b11 = new int[n/2][n/2];
        int[][] b12 = new int[n/2][n/2];
        int[][] b21 = new int[n/2][n/2];
        int[][] b22 = new int[n/2][n/2];

        split(a, a11, 0, 0);
        split(a, a12, 0, n/2);
        split(a, a21, n/2, 0);
        split(a, a22, n/2, n/2);

        split(b, b11, 0, 0);
        split(b, b12, 0, n/2);
        split(b, b21, n/2, 0);
        split(b, b22, n/2, n/2);

        //conquer step
        int[][] m1 = strassenMultiply(add(a11, a22), add(b11, b22));
        int[][] m2 = strassenMultiply(add(a21, a22), b11);
        int[][] m3 = strassenMultiply(a11, subtract(b12, b22));
        int[][] m4 = strassenMultiply(a22, subtract(b21, b11));
        int[][] m5 = strassenMultiply(add(a11, a12), a22);
        int[][] m6 = strassenMultiply(subtract(a21, a11), add(b11, b12));
        int[][] m7 = strassenMultiply(subtract(a12, a22), add(b21, b22));

        int[][] c11 = add(subtract(add(m1, m4), m5), m7);
        int[][] c12 = add(m3, m5);
        int[][] c21 = add(m2, m4);
        int[][] c22 = add(subtract(add(m1, m3), m2), m6);

        int[][] c = new int[n][n];
        join(c11, c, 0, 0);
        join(c12, c, 0, n/2);
        join(c21, c, n/2, 0);
        join(c22, c, n/2, n/2);

        return c;
    }

    private static void split(int[][] parent, int[][] child, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
                child[i1][j1] = parent[i2][j2];
            }
        }
    }

    private static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    private static int[][] subtract(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    private static void join(int[][] child, int[][] parent, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
                parent[i2][j2] = child[i1][j1];
            }
        }
    }
}