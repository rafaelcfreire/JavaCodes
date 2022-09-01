package dsa.book;

import java.util.Arrays;

public class Binary {
    int[] A;

    public static void main(String[] args) {
        Binary b = new Binary();
        b.A = new int[3];
        b.getBinary(3);
    }

    public void getBinary(int n) {
        if (n < 1)
            System.out.println(Arrays.toString(A));
        else {
            A[n - 1] = 0;
            getBinary(n - 1);
            A[n - 1] = 1;
            getBinary(n - 1);
        }
    }

    public void getBinaryIterative(int n) {
        for (int i = n; i >= 0; i--) {
            A[i - 1] = 0;
            System.out.println(Arrays.toString(A));
            A[i - 1] = 1;
        }
    }
}
