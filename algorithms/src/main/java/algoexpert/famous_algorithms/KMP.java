package algoexpert.famous_algorithms;

public final class KMP {
    public static void main(String[] args) {
//        System.out.println(knuthMorrisPrattAlgorithm("ABC ABCDAB ABCDABCDABDE", "ABCDABEED"));
//        System.out.println(knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcdaed"));
//        System.out.println(knuthMorrisPrattAlgorithm("testwafwafawfawfawfawfawfawfawfa", "fawfawfawfawfa"));
//        System.out.println(knuthMorrisPrattAlgorithm("tesseatesgawatewtesaffawgfawtteafawtesftawfawfawfwfawftest", "test"));
//        System.out.println(knuthMorrisPrattAlgorithm("aaabaabacdedfaabaabaaa", "aabaabaaa"));
//        System.out.println(knuthMorrisPrattAlgorithm("abxabcabcaby", "abcaby"));
//        System.out.println(knuthMorrisPrattAlgorithm("decadaafcdf", "daf"));
        System.out.println(knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcaefaeiaefcd  "));

    }

    public static boolean knuthMorrisPrattAlgorithm(String string, String pat) {
        int m = pat.length();
        int R = 256;
        int[][] dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;

        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }

        int i, j, n = string.length();
        for (i = 0, j = 0; i < n && j < m; i++)
            j = dfa[string.charAt(i)][j];
        if (j == m)
            return true;
        else
            return false;
    }

}
