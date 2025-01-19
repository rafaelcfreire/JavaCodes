package sedgewick.chp5;

public final class BoyerMoore {
    private int[] right;

    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore();
        int result = bm.search("FINDINAHAYSTACKNEEDLE", "NEEDLE");
    }

    public int search(String txt, String pat) {
        fillRightArray(pat);
        int n = txt.length();
        int m = pat.length();
        int skip;

        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;

            for (int j = m - 1; j >= 0; j--)
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            if (skip == 0)
                return i;
        }
        return n;
    }

    public void fillRightArray(String pat) {
        int m = pat.length();
        int R= 256;
        right = new int[256];
        for (int i = 0; i < R; i++)
            right[i] = -1;
        for (int i = 0; i < m; i++)
            right[pat.charAt(i)] = i;
    }
}
