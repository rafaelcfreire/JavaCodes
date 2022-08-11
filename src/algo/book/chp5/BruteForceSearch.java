package algo.book.chp5;

public class BruteForceSearch {
    public static void main(String[] args) {
        search("AAAAC", "AAAAAAAAAB");
    }

    public static int search(String pat, String txt) {
        int j, m = pat.length();
        int i, n = txt.length();

        for (i = 0, j = 0; i < n && j < m; i++) {
            if (pat.charAt(j) == txt.charAt(i))
                j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == m)
            return i - m;
        else
            return n;
    }
}
