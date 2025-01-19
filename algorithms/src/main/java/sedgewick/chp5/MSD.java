package sedgewick.chp5;

public final class MSD {
    private static String[] aux;
    private static int R = 256;
    private static final int CUTOFF = 3;

    public static void main(String[] args) {
        String[] values = new String[]{
            "she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"
        };
        sort(values);
    }

    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[a.length];
        sort(a, 0, n - 1, 0);
        System.out.println(a);
    }

    private static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        return -1;
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + CUTOFF) {
            quicksort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;

        for (int r = 0; r < R+ 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int i = 0; i < R; i++)
            sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
    }

    private static void quicksort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exchange(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++)
            if (v.charAt(i) < w.charAt(i))
                return true;
            else if (v.charAt(i) > w.charAt(i))
                return false;
        return v.length() < w.length();
    }

    private static void exchange(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
