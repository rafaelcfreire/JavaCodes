package algo.book.chp5;

public class KeyIndexedCounting {

    public static void main(String[] args) {
        int[] result = keyIndexSorting(new int[]{1, 2, 5, 1, 3, 1, 4, 1, 2, 5, 1}, 6);
    }

    public static int[] keyIndexSorting(int[] a, int R) {
        int n = a.length;
        int[] count = new int[R + 1];
        int[] aux = new int[n];

        for (int i = 0; i < n; i++)
            count[a[i] + 1] += 1;

        for (int i = 0; i < R; i++)
            count[i + 1] += count[i];

        for (int i = 0; i < n; i++)
            aux[count[a[i]]++] = a[i];

        for (int i = 0; i < n; i++)
            a[i] = aux[i];
        return a;
    }
}
