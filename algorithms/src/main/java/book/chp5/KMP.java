package book.chp5;

public final class KMP {
    private String pat;
    private int[][] dfa;

    public static void main(String[] args) {
        KMP kmp = new KMP("ABCDABD");
        System.out.println(kmp.search("ABC ABCDAB ABCDABCDABDE"));
    }

    public KMP(String pat) {
        this.pat = pat;
        int m = pat.length();
        int R = 256;
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }
    }

    public int search(String txt) {
        int i, j, n = txt.length(), m = pat.length();
        for (i = 0, j = 0; i < n && j < m; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == m)
            return i - m;
        else
            return n;
    }
}
