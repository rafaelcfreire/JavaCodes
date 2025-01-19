package sedgewick.chp5;

public final class LSD {
    public static void main(String[] args) {
        String[] a = new String[13];
        a[0] = "4PGC938";
        a[1] = "2IYE230";
        a[2] = "3CI0720";
        a[3] = "1ICK750";
        a[4] = "1OHV845";
        a[5] = "4JZY524";
        a[6] = "1ICK750";
        a[7] = "3CI0720";
        a[8] = "1OHV845";
        a[9] = "1OHV845";
        a[10] = "2RLA629";
        a[11] = "2RLA629";
        a[12] = "3ATW723";
        sort(a, 6);
    }

    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
        System.out.println(a);
    }
}
