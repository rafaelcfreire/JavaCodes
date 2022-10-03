package algo.book.chp5;

public final class BruteForceSearch {
    public static void main(String[] args) {
        System.out.println(search("AAAAB", "AAAAAAAAAB"));
    }

    public static int search(String pat, String txt) {
        int j, m = pat.length();
        int i, n = txt.length();

        for (j = 0, i = 0; j < m && i < n; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
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
